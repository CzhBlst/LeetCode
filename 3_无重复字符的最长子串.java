/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int max = 0;
        int maxNow = 0;
        int cursor = 0;
        int flag = 0;
        if(s.length()==0) return result;
        else{
            for(int i = 0; i<s.length(); i++){
                if(flag == 1){
                    i--;
                    flag = 0;
                }
                if(i == 0){
                    maxNow = 1;
                }else{
                    int a = i - 1;
                    while(a>=cursor){
                        if(s.charAt(i)==s.charAt(a--)) {
                            flag = 1;
                            if(maxNow>max) max = maxNow;
                            cursor = a + 2;
                            maxNow = i - cursor;
                            break;
                        }
                    }
                    if(flag==0) maxNow = maxNow + 1;
                }
            }
        }
        if(maxNow>max) max = maxNow;
        result = max;
        return result;
    }
}
// @lc code=end

