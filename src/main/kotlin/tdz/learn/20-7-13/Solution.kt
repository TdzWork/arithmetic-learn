package tdz.learn.`20-7-13`

/**
 * @ClassName Solution
 * @Description 寻找数组的中心索引
 * @Author Tandz
 * @Date 2020-07-14 17:36
 *
给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。

我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

 

示例 1：

输入：
nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
同时, 3 也是第一个符合要求的中心索引。
示例 2：

输入：
nums = [1, 2, 3]
输出：-1
解释：
数组中不存在满足此条件的中心索引。
 

说明：

nums 的长度范围为 [0, 10000]。
任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-pivot-index
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class Solution {
    companion object {
        fun pivotIndex(nums: IntArray): Int {
            var index = -1
            var sums = 0
            var lsum = 0
            var rsum = 0
            nums.forEach {
                sums+=it
            }
            for(i in 0 until nums.size){
                if(i>0){
                    lsum += nums[i-1]
                }
                rsum = sums - lsum - nums[i]
                if(lsum==rsum){
                    index = i
                    break
                }
            }
            return index
        }
    }
}