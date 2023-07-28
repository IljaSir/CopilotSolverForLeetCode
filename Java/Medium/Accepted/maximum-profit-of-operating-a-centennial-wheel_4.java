class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        
        int max = 0;
        int maxIndex = 0;
        int sum = 0;
        int index = 0;
        int current = 0;
        while (index < customers.length || current > 0) {
            if (index < customers.length) {
                current += customers[index];
            }
            int boarding = Math.min(current, 4);
            current -= boarding;
            sum += boarding;
            int profit = sum * boardingCost - (index + 1) * runningCost;
            if (profit > max) {
                max = profit;
                maxIndex = index + 1;
            }
            index++;
        }
        return max > 0 ? maxIndex : -1;
    }
}