package tdz.learn.`20-7-8`

import kotlin.math.abs

/**
 * @ClassName Solution
 * @Description 存在重复元素 III
 * @Author Tandz
 * @Date 2020-07-10 15:59
 *
 *
 *
在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。

如果存在则返回 true，不存在返回 false。

 

示例 1:

输入: nums = [1,2,3,1], k = 3, t = 0
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1, t = 2
输出: true
示例 3:

输入: nums = [1,5,9,1,5,9], k = 2, t = 3
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class Solution {
    companion object{
        fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
            var flag = false
            for( i in 0 until  nums.size){
                val j =i+1
                for (n  in j until nums.size){
                    if((Math.abs(nums[n].toLong()-nums[i].toLong())<=t)&&(n-i)<=k){
                        flag = true
                    }
                }
            }
            return flag
        }
    }
}