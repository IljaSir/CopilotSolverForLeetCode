class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        
        int maxProfit = 0;
        int curProfit = 0;
        int maxRotate = 0;
        int curRotate = 0;
        int curWait = 0;
        for (int i = 0; i < customers.length; i++) {
            curRotate++;
            curWait += customers[i];
            int board = Math.min(curWait, 4);
            curWait -= board;
            curProfit += board * boardingCost - runningCost;
            if (curProfit > maxProfit) {
                maxProfit = curProfit;
                maxRotate = curRotate;
            }
        }
        while (curWait > 0) {
            curRotate++;
            int board = Math.min(curWait, 4);
            curWait -= board;
            curProfit += board * boardingCost - runningCost;
            if (curProfit > maxProfit) {
                maxProfit = curProfit;
                maxRotate = curRotate;
            }
        }
        return maxProfit > 0 ? maxRotate : -1;
    }
}