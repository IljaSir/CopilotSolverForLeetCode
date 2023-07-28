class Solution {
public:
    int minOperationsMaxProfit(vector<int>& customers, int boardingCost, int runningCost) {
        
        int n = customers.size();
        int i = 0;
        int total = 0;
        int profit = 0;
        int maxProfit = 0;
        int maxIndex = -1;
        while (i < n || total) {
            if (i < n) {
                total += customers[i];
            }
            int board = min(total, 4);
            total -= board;
            profit += board * boardingCost - runningCost;
            if (profit > maxProfit) {
                maxProfit = profit;
                maxIndex = i + 1;
            }
            ++i;
        }
        return maxIndex;
    }
};