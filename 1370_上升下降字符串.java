/*
 * @lc app=leetcode.cn id=1370 lang=java
 *
 * [1370] 上升下降字符串
 */

// @lc code=start
class Solution {
    public String sortString(String s) {
        String result = "";
        String nowStr = null;
        int flag = 0;
        for(int i = 0; i < s.length(); i++){
            if(i == 0) result = result + getMin(s, '`')[0];
            else{
                nowStr = s.substring(i, s.length());
                if(flag == 0){
                    String minStr[] = getMin(nowStr,s.charAt(i - 1));
                    if(!minStr[1].equals("0")){
                        result = result + minStr[0];
                    }else{
                        flag = 1;
                        i--;
                    }
                }else if(flag == 1){
                    String maxStr[] = getMax(nowStr,s.charAt(i - 1));
                    if(!maxStr[1].equals("0")){
                        result = result + maxStr[0];
                    }else{
                        flag = 0;
                        i--;
                    }
                }
                
            }
        }
        return result;
    }
    public String[] getMin(String s, char lst_min){
        String result[] = {"","0"};
        char min = '`';
        for(int i = 0; i<s.length(); i++){
            if(i == 0) min = s.charAt(i);
            else{
                if(min > s.charAt(i)) min = s.charAt(i);
            }
        }
        if(lst_min > min){
            result[0] = result[0] + min;
            result[1] = "1";
        }
        return result;
    }
    public String[] getMax(String s, char lst_max){
        String result[] = {"","0"};
        char max = '0';
        for(int i = 0; i < s.length(); i++){
            if(i == 0) max = s.charAt(i);
            else{
                if(max < s.charAt(i)){
                    max = s.charAt(i);
                }
            }
        }
        if(lst_max < max){
            result[0] = result[0] + max;
            result[1] = "1"; 
        }
        return result;
    }
}
// @lc code=end

