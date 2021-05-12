import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: czh
 * @Date: 2021-05-11 17:23:16
 * @LastEditTime: 2021-05-11 17:49:25
 * @Description: file content
 */
/*
 * @lc app=leetcode.cn id=1734 lang=java
 *
 * [1734] 解码异或后的排列
 */

// @lc code=start
class Solution {
    public int[] decode(int[] encoded) {
        int first = 1;
        List<Integer> tmpList = new ArrayList<Integer>();
        while(!isEncoded(encoded, first, tmpList)) {
            first++;
            tmpList.clear();
        }
        int[] perm = new int[encoded.length + 1];
        for(int i = 0; i < perm.length; i++) {
            perm[i] = tmpList.get(i);
        }
        return perm;
        
    }
    public boolean isEncoded(int[] encoded, int first, List<Integer> tmpList) {
        int[] perm = new int[encoded.length + 1];
        perm[0] = first;
        tmpList.add(Integer.valueOf(first));
        for(int i = 1; i < encoded.length +1; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
            if(tmpList.contains(Integer.valueOf(perm[i]))) {
                return false;
            } else {
                tmpList.add(Integer.valueOf(perm[i]));
            }
        }
        if(tmpList.contains(0) || !tmpList.contains(1)) {
            return false;
        }
        return true;
    }
}
// @lc code=end

