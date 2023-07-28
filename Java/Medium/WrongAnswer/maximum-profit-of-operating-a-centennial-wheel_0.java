class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        
        int n = customers.length;
        int[] waiting = new int[n + 1];
        for (int i = 0; i < n; i++) {
            waiting[i + 1] = waiting[i] + customers[i];
        }
        int max = 0;
        int maxIndex = -1;
        int profit = 0;
        for (int i = 0; i <= n; i++) {
            int w = waiting[i];
            int b = Math.min(w, 4);
            profit += b * boardingCost - runningCost;
            if (profit > max) {
                max = profit;
                maxIndex = i;
            }
            waiting[i] -= b;
        }
        return maxIndex == -1 ? -1 : maxIndex + 1;
    }
}