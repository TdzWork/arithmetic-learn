package tdz.learn.`20-7-2`

import com.alibaba.fastjson.JSON

/**
 * @ClassName Solution
 * @Description
 * @Author Tandz
 * @Date 2020-07-02 17:19
 *
 *
 *
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 2 1 34567 3124567
                          index = 0    1
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    companion object{
        fun rotate(nums: IntArray, k: Int): Unit {
            var tmp = 0
            for(i in 0 until k){
                for((n, j) in (0 until nums.size-1).withIndex()){
                   tmp = nums[j+1]
                   nums[j+1] = nums[j-n]
                   nums[j-n] = tmp
                }
            }
        }
    }
}