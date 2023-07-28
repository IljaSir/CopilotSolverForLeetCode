class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        
        int profit = 0;
        int maxProfit = 0;
        int maxProfitIndex = -1;
        int currCustomer = 0;
        int currProfit = 0;
        int currBoarding = 0;
        int currRunning = 0;
        int i = 0;
        while (i < customers.length || currCustomer > 0) {
            if (i < customers.length) {
                currCustomer += customers[i];
            }
            currBoarding = Math.min(currCustomer, 4);
            currCustomer -= currBoarding;
            currProfit = currBoarding * boardingCost - runningCost;
            profit += currProfit;
            i++;
            if (profit > maxProfit) {
                maxProfit = profit;
                maxProfitIndex = i;
            }
        }
        return maxProfit > 0 ? maxProfitIndex : -1;
    }
}