class Solution {
public:
    int minOperationsMaxProfit(vector<int>& customers, int boardingCost, int runningCost) {
        
        int n = customers.size();
        int res = -1, maxProfit = 0;
        int cur = 0, wait = 0, i = 0;
        while (i < n || wait > 0) {
            if (i < n) {
                wait += customers[i++];
            }
            int board = min(4, wait);
            wait -= board;
            cur += board;
            int profit = cur * boardingCost - (i * runningCost);
            if (profit > maxProfit) {
                maxProfit = profit;
                res = i;
            }
        }
        return res;
    }
};