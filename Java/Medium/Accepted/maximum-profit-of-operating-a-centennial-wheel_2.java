class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        
        int max = 0;
        int maxI = -1;
        int i = 0;
        int profit = 0;
        int waiting = 0;
        while (i < customers.length || waiting > 0) {
            int c = i < customers.length ? customers[i] : 0;
            int b = Math.min(4, waiting + c);
            waiting = waiting + c - b;
            profit = profit + b * boardingCost - runningCost;
            if (profit > max) {
                max = profit;
                maxI = i + 1;
            }
            i++;
        }
        return maxI;
    }
}