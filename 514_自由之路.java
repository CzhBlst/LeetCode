/*
 * @lc app=leetcode.cn id=514 lang=java
 *
 * [514] 自由之路
 */

// @lc code=start
class Solution {
    public int findRotateSteps(String ring, String key) {
        int result = 0;
        int cursor = 0;
        int oneMove[] = {0,0,0};
        for(int i = 0; i<key.length(); i++){
            oneMove = oneStep(ring, cursor, key, i);
            result = result + oneMove[0];
            cursor = oneMove[1];
            System.out.println("Move to :" + oneMove[1] + " Lentgh :" +oneMove[0]);
        }
        return result;
    }
    public int[] oneStep(String ring, int cursor ,String key, int i){
        int result[] = {0,0,0};
        char charNow = key.charAt(i);
        int r_len = ring.length();
        int leftCur = cursor;
        int rightCur = cursor;
        int leftS = 0;
        int rightS = 0;
        int flag = 0;
        while(ring.charAt(leftCur) != charNow){
            if(leftCur != 0) leftCur--;
            else leftCur = r_len - 1;
            leftS++;
            flag = 1;
        }
        while(ring.charAt(rightCur) != charNow){
            if(rightCur != r_len - 1) rightCur++;
            else rightCur = 0;
            rightS++;
            flag = 1;
        }
        if(rightS > leftS){
            result[0] = leftS + 1;
            result[1] = leftCur;
            result[2] = -1;
        }else if(leftS == rightS && i != key.length() - 1){
            char theSameChar = key.charAt(i);
            int firstDiffer = 0;
            for(int j = i; j<key.length(); j++){
                if(key.charAt(j) != theSameChar) {
                    firstDiffer = j;
                    break;
                }
            }
            if(whichCloserToDiffer(rightCur, leftCur, firstDiffer, ring.length()).equals("RIGHT")){
                if(oneStep(ring, leftCur, key, i+1)[0] >= 
                oneStep(ring, rightCur, key, i+1)[0]){
                        result[0] = rightS + 1;
                        result[1] = rightCur;
                        System.out.println("Move right:" + key.charAt(i) + " " + i + " " + result[0]);
                    }else{
                        result[0] = leftS + 1;
                        result[1] = leftCur;
                        //System.out.println("Move left:"+key.charAt(i) + " " + i + " " + result[0]);
                    }
            }else{
                if(oneStep(ring, leftCur, key, i+1)[0] > 
                oneStep(ring, rightCur, key, i+1)[0]){
                        result[0] = rightS + 1;
                        result[1] = rightCur;
                        System.out.println("Move right:" + key.charAt(i) + " " + i + " " + result[0]);
                    }else{
                        result[0] = leftS + 1;
                        result[1] = leftCur;
                        //System.out.println("Move left:"+key.charAt(i) + " " + i + " " + result[0]);
                    }
            }
            
                    //System.out.println("");
        }else{
            result[0] = rightS + 1;
            result[1] = rightCur;
            result[2] = 1;
        }
        return result;
    }
    public String whichCloserToDiffer(int rightCur, int leftCur, 
                int differ, int keyLength)
    {
        int left2Left = 0;
        int left2Right = 0;
        int right2Left = 0;
        int right2Right = 0;
        int rightS = 0;
        int leftS = 0;
        if(differ > leftCur){
            left2Left = leftCur + keyLength - differ;
            left2Right = differ - leftCur;
        }else if(differ < leftCur){
            left2Left = leftCur - differ;
            left2Right = differ + keyLength - leftCur;
        }else{
            System.out.println("Wrong");
        }
        if(differ > rightCur){
            right2Left = rightCur + keyLength - differ;
            right2Right = differ - rightCur;
        }else if(differ < rightCur){
            right2Left = rightCur - differ;
            right2Right = differ + keyLength - rightCur;
        }else{
            System.out.println("Wrong");
        }
        if(left2Left > left2Right){
            leftS = left2Right;
        }else leftS = left2Left;
        if(right2Left > right2Right) rightS = right2Right;
        else rightS = right2Left;

        if(leftS > rightS) return "RIGHT";
        else return "LEFT";
    }
}
// @lc code=end

