package tdz.learn.`20-6-30`

/**
 * @ClassName Solution
 * @Description 买卖股票的最佳时机 II
 * @Author Tandz
 * @Date 2020-06-30 14:51
 */
/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */
class Solution {
    companion object {
        /**
         * 交易次数最少，算法较复杂，利益最大化（如果在有手续费的情况下）
         */
        fun maxProfit(prices: IntArray): Int {
            var minFlag = false
            var min: Int = 0
            var income: Int = 0
            if(prices.size>2){
                for (i in prices.indices) {
                    val j = i + 1
                    if (j + 1 <= prices.size && prices[i] < prices[j]) {
                        if (!minFlag) {
                            min = i
                            minFlag =true
                        }
                    }
                    if(j + 1 <= prices.size && minFlag&&prices[i] > prices[j]){
                        income +=  prices[i]  - prices[min]
                        min = j
                        minFlag = true
                    }
                }
                if (minFlag) {
                    if (income == 0 && prices[1] > prices[0]) {
                        income += prices[prices.size - 1] - prices[0]
                    }else{
                        income += prices[prices.size - 1] - prices[min]
                    }
                }
            }else if(prices.size==2){
              if(prices[1] > prices[0]){
                  income = prices[1] - prices[0]
              }
            }
            return income
        }

        /**
         * 交易次数最多，算法最简单
         */
        fun maxProfit02(prices: IntArray): Int {
            var income: Int = 0
            for (i in 1 until  prices.size){
                if(prices[i]>prices[i-1]){
                    income += prices[i]-prices[i-1]
                }
            }
            return income
        }
    }
}