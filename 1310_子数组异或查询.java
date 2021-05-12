/*
 * @Author: czh
 * @Date: 2021-05-12 16:20:36
 * @LastEditTime: 2021-05-12 16:24:38
 * @Description: file content
 */
/*
 * @lc app=leetcode.cn id=1310 lang=java
 *
 * [1310] 子数组异或查询
 */

// @lc code=start
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int min,max;
        for(int i = 0; i < queries.length; i++) {
            min = queries[i][0];
            max = queries[i][1];
            for(int j = min; j <= max; j++){
                result[i] ^= arr[j];
            }
        }
        return result;
    }
}
// @lc code=end

