class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        
        int n = customers.length;
        int max = 0;
        int maxIndex = -1;
        int wait = 0;
        int cur = 0;
        int i = 0;
        int count = 0;
        while (i < n || wait > 0) {
            if (i < n) {
                wait += customers[i];
            }
            int board = Math.min(wait, 4);
            wait -= board;
            cur = cur + board * boardingCost - runningCost;
            count++;
            if (cur > max) {
                max = cur;
                maxIndex = count;
            }
            i++;
        }
        return maxIndex;
    }
}