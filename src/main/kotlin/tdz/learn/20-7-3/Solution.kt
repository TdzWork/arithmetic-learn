package tdz.learn.`20-7-3`

/**
 * @ClassName Solution
 * @Description多数元素
 * @Author Tandz
 * @Date 2020-07-06 10:09
 *
 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class Solution {
    companion object{
        fun majorityElement(nums: IntArray): Int {
            val map = mutableMapOf<Int,Int>()
            val n = nums.size/2
            var i = 0
            nums.forEach {
                if(map.containsKey(it)){
                    map[it]?.plus(1)?.let { it1 -> map.put(it, it1) }
                }else{
                    map[it]=1
                }
                if(map[it]!! >n){
                    i = it
                }
            }
            return i
        }
    }
}