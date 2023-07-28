class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        
        int maxProfit = 0;
        int maxProfitIndex = -1;
        int totalProfit = 0;
        int totalCustomers = 0;
        int totalRotations = 0;
        for (int i = 0; i < customers.length; i++) {
            totalCustomers += customers[i];
            int currentProfit = 0;
            if (totalCustomers >= 4) {
                currentProfit = 4 * boardingCost;
                totalCustomers -= 4;
            } else {
                currentProfit = totalCustomers * boardingCost;
                totalCustomers = 0;
            }
            totalProfit += currentProfit - runningCost;
            totalRotations++;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                maxProfitIndex = totalRotations;
            }
        }
        int currentProfit = 0;
        while (totalCustomers > 0) {
            if (totalCustomers >= 4) {
                currentProfit = 4 * boardingCost;
                totalCustomers -= 4;
            } else {
                currentProfit = totalCustomers * boardingCost;
                totalCustomers = 0;
            }
            totalProfit += currentProfit - runningCost;
            totalRotations++;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                maxProfitIndex = totalRotations;
            }
        }
        return maxProfit > 0 ? maxProfitIndex : -1;
    }
}