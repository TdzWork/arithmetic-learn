package tdz.learn.`20-7-9`

import java.lang.Integer.min

/**
 * @ClassName Solution
 * @Description 长度最小的子数组
 * @Author Tandz
 * @Date 2020-07-10 16:42

给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。

 

示例：

输入：s = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。


进阶：

如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class Solution {
    companion object {
        fun minSubArrayLen(s: Int, nums: IntArray): Int {
            val len = nums.size
            if (len == 0) {
                return 0
            }
            var ans = Integer.MAX_VALUE
            val sums = IntArray(len)
            sums[0] = nums[0]
            for (i in 1 until len) {
                sums[i] = sums[i - 1] + nums[i];
            }
            for (i in 0 until len) {
                for (j in i until len) {
                    val sum = sums[j] - sums[i] + nums[i]
                    if (sum >= s) {
                        if(ans>(j - i + 1)){
                            ans = j - i + 1
                        }
                        break
                    }
                }
            }
            return if (ans != Integer.MAX_VALUE) ans else 0
        }
    }
}