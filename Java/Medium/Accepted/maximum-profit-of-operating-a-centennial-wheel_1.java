class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        
        int maxProfit = 0;
        int maxRotations = -1;
        int rotations = 0;
        int profit = 0;
        int waiting = 0;
        for (int i = 0; i < customers.length || waiting > 0; i++) {
            if (i < customers.length) {
                waiting += customers[i];
            }
            int boarded = Math.min(4, waiting);
            waiting -= boarded;
            profit += boarded * boardingCost - runningCost;
            rotations++;
            if (profit > maxProfit) {
                maxProfit = profit;
                maxRotations = rotations;
            }
        }
        return maxRotations;
    }
}