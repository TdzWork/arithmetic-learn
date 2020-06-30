package tdz.learn.`20-6-29`

/**
 * @ClassName Solution
 * @Description  删除排序数组中的重复项
 * @Author Tandz
 * @Date 2020-06-29 16:02
 */

class Solution {
    companion object {
        fun removeDuplicates(nums: IntArray): Int {
            var len: Int = nums.size
            val index = 0
            for (i in 0 until len - 1) {
                if (nums[i] == nums[i + 1]) {
                    var j = i + 1
                    while (j < len && nums[i] == nums[j]) {
                        j++
                    }
                    val num = j - i - 1
                    for (x in i + 1 until len - num) {
                        nums[x] = nums[x + num]
                    }
                    len -= num
                }
            }

            return len
        }

        /**
         * 最优解
         */
        fun removeDuplicates02(nums: IntArray): Int {
            val len: Int = nums.size
            var index = 0
            for (i in 1 until len ) {
                if(nums[i] != nums[index]){
                    index++
                    nums[index] = nums[i]
                }
            }
            return index+1
        }

    }
}