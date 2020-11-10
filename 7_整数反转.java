import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int pop = x % 10;
            result = result * 10 + pop;
            x /= 10; 
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                return 0;
            }          
        }
        return (int)result;
    }

}
// @lc code=end

