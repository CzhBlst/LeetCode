import sun.misc.PostVMInitHook;
import sun.tracing.PrintStreamProviderFactory;

/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else{
            int reverse = 0;
            int num = x;
            while(x != 0){
                int pop = x % 10;
                reverse = reverse * 10 + pop;
                x /= 10;
            }
            // if(reverse == num){
            //     return true;
            // }else{
            //     return false;
            // }
            return reverse == num;
        }
    }
}
// @lc code=end

