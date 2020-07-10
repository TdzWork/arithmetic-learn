package tdz.learn.`20-7-7`

/**
 * @ClassName Solution
 * @Description 存在重复元素 II
 * @Author Tandz
 * @Date 2020-07-06 16:50
 *
 *
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。


示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false

 *
 */
class Solution {
    companion object{
        fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
            val map = mutableMapOf<Int,IntArray>()
            var flag = false
            for(i in nums.indices){
                if(!map.containsKey(nums[i])){
                    map[nums[i]] = intArrayOf(i)
                }else{
                    map[nums[i]]= map[nums[i]]!!.plus(i)
                }
                if(map[nums[i]]!!.size>1){
                    for(j in 1 until  map[nums[i]]!!.size){
                        if((map[nums[i]]!![j] - map[nums[i]]!![j-1])<=k){
                            flag = true
                        }
                    }
                }
            }
            return flag
        }
    }

}