class Solution {
public:
    int minOperationsMaxProfit(vector<int>& customers, int boardingCost, int runningCost) {
        
        int maxProfit = 0;
        int maxRotate = 0;
        int profit = 0;
        int rotate = 0;
        int wait = 0;
        for (int i = 0; i < customers.size(); ++i) {
            wait += customers[i];
            profit -= runningCost;
            rotate++;
            int board = min(4, wait);
            wait -= board;
            profit += board * boardingCost;
            if (profit > maxProfit) {
                maxProfit = profit;
                maxRotate = rotate;
            }
        }
        while (wait > 0) {
            profit -= runningCost;
            rotate++;
            int board = min(4, wait);
            wait -= board;
            profit += board * boardingCost;
            if (profit > maxProfit) {
                maxProfit = profit;
                maxRotate = rotate;
            }
        }
        return maxProfit <= 0 ? -1 : maxRotate;
    }
};