package tdz.learn.`20-7-1`

/**
 * @ClassName Solution
 * @Description 搜索旋转排序数组
 * @Author Tandz
 * @Date 2020-07-01 15:00
 *
 *
 *
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    companion object {
        fun search(nums: IntArray, target: Int): Int {
            var newIntArray = nums
            var targetIndex = -1
            var n = 0
            while (targetIndex == -1 && newIntArray.size > 1) {
                when {
                    target < newIntArray[(newIntArray.size / 2)] && target >= newIntArray[0] -> {
                        newIntArray = newIntArray.copyOfRange(0, (newIntArray.size / 2))
                    }
                    target > newIntArray[(newIntArray.size / 2)] && target <= newIntArray[newIntArray.size - 1] -> {
                        if (newIntArray.size % 2 == 0) {
                            newIntArray = newIntArray.copyOfRange((newIntArray.size / 2), newIntArray.size)
                            n += newIntArray.size
                        } else {
                            newIntArray = newIntArray.copyOfRange((newIntArray.size / 2), newIntArray.size)
                            n += newIntArray.size - 1
                        }
                    }
                    target < newIntArray[(newIntArray.size / 2)] && target <= newIntArray[0] -> {
                        if (newIntArray.size % 2 == 0) {
                            newIntArray = newIntArray.copyOfRange((newIntArray.size / 2 - 1), newIntArray.size)
                            n += newIntArray.size - 2
                        } else {
                            newIntArray = newIntArray.copyOfRange((newIntArray.size / 2), newIntArray.size)
                            n += newIntArray.size - 1
                        }
                    }
                    target > newIntArray[(newIntArray.size / 2)] && target >= newIntArray[newIntArray.size - 1] -> {
                        newIntArray = newIntArray.copyOfRange(0, (newIntArray.size / 2))
                    }
                    else -> {
                        targetIndex = (newIntArray.size / 2) + n
                    }
                }
            }
            if (newIntArray.size == 1 && target == newIntArray[0]) {
                targetIndex = 0 + n
            }

            return targetIndex
        }

        fun search02(nums: IntArray, target: Int): Int {
            var targetIndex = -1
            for (i in nums.indices) {
                if(targetIndex==-1){
                    targetIndex = if (target == nums[i])
                        i
                    else
                        -1
                }
            }
            return targetIndex
        }
    }

}