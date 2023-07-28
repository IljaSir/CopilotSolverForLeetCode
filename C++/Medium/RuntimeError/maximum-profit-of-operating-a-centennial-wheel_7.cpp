class Solution {
public:
    int minOperationsMaxProfit(vector<int>& customers, int boardingCost, int runningCost) {
        
        int total = 0;
        int count = 0;
        int maxProfit = 0;
        int maxCount = -1;
        int i = 0;
        int n = customers.size();
        while (i < n || total > 0) {
            if (i < n) {
                total += customers[i];
            }
            int cur = min(total, 4);
            total -= cur;
            int profit = cur * boardingCost - runningCost;
            count++;
            if (profit > 0) {
                maxProfit += profit;
                if (maxProfit > maxCount) {
                    maxCount = maxProfit;
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }
};