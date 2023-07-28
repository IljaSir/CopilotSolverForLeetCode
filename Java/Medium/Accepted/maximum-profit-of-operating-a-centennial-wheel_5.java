class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        
        int max = 0;
        int maxIndex = -1;
        int sum = 0;
        int count = 0;
        int i = 0;
        while(i < customers.length || sum > 0) {
            if(i < customers.length) {
                sum += customers[i];
            }
            int cur = Math.min(sum, 4);
            sum -= cur;
            count += cur;
            int profit = count * boardingCost - (i + 1) * runningCost;
            if(profit > max) {
                max = profit;
                maxIndex = i + 1;
            }
            i++;
        }
        return maxIndex;
    }
}