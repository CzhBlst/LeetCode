/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        String maxNow = null;
        String max = null;
        if(isPalindrome(s)) return s;
        for(int i = 0; i<s.length(); i++){
            for(int j = s.length(); j>i; j--){
                if(isPalindrome(s.substring(i, j))){
                    if(i == 0) max = s.substring(i, j);
                    else{
                        maxNow = s.substring(i, j);
                        max = maxNow.length() > max.length() ? maxNow : max;
                    }
                    break;
                }
            }
        }
        return max;
    }
    public boolean isPalindrome(String s){
        boolean flag = false;
        // String preHalf = null;
        // String lastHalf = null;
        // if(s.length() == 1) return true;
        // if(s.length() == 2) {
        //     if(s.charAt(1)==s.charAt(0)) return true;
        //     else return false;
        // }

        // if(s.length()%2 == 0){
        //     preHalf  = s.substring(0, s.length()/2);
        //     lastHalf = s.substring(s.length()/2, s.length());

        // }else{
            
        //     preHalf = s.substring(0, s.length()/2 );
        //     lastHalf = s.substring(s.length()/2 + 1, s.length());
        //     System.out.println(preHalf + "0.0" +lastHalf);
        // }
        
        // if(preHalf.equals(lastHalf)) return true;
        // else return false;
        for(int i = 0;i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                flag = true;
                break;
            }
        }
        if(flag) return false;
        else return true;
    }
}
// @lc code=end

