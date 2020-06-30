/**
 * @ClassName Solution
 * @Description
 * @Author Tandz
 * @Date 2020-06-30 16:44
 */
public class Solution {
    public static int maxProfit(int[] prices){
        boolean minFlag = false;
        int min = 0;
        int income = 0;
        if(prices.length>2){
            for (int i= 0;i< prices.length;i++) {
                int j = i + 1;
                if (j + 1 <= prices.length && prices[i] < prices[j]) {
                    if (!minFlag) {
                        min = i;
                        minFlag =true;
                    }
                }
                if(j + 1 <= prices.length && minFlag&&prices[i] > prices[j]){
                    income +=  prices[i]  - prices[min];
                    min = j;
                    minFlag = true;
                }
            }
            if (minFlag) {
                if (income == 0 && prices[1] > prices[0]) {
                    income += prices[prices.length - 1] - prices[0];
                }else{
                    income += prices[prices.length - 1] - prices[min];
                }
            }
        }else if(prices.length==2){
            if(prices[1] > prices[0]){
                income = prices[1] - prices[0];
            }
        }
        return income;
    }
}
