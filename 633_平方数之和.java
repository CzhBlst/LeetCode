/*
 * @Author: czh
 * @Date: 2021-04-28 17:40:21
 * @LastEditTime: 2021-04-28 18:23:25
 * @Description: file content
 */
/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        // if (a+b)^2 = c - 2ab
        for(long i = 0; i * i <= c; i++) {
            for(long j = 0; i*i + j*j <= c ; j++){
                if(c == i*i + j*j) return true;
            }
        }
        // int left = 0;
        // int right = (int)Math.sqrt(c);
        // while(left <= right) {
        //     if(left * left + right * right == c) {
        //         return true;
        //     } else if(left * left + right * right > c) {
        //         right -= 1;
        //     } else {
        //         left += 1;
        //     }
        // }

        return false;
    }
}
// @lc code=end

