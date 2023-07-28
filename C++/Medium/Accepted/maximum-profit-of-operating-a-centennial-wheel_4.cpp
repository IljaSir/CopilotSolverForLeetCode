class Solution {
public:
    int minOperationsMaxProfit(vector<int>& customers, int boardingCost, int runningCost) {
        
        int n = customers.size();
        int i = 0;
        int profit = 0;
        int maxProfit = 0;
        int maxProfitCycle = -1;
        int waiting = 0;
        int cycle = 0;
        while (i < n || waiting > 0) {
            if (i < n) {
                waiting += customers[i];
            }
            int boarding = min(waiting, 4);
            waiting -= boarding;
            profit += boarding * boardingCost - runningCost;
            ++cycle;
            if (profit > maxProfit) {
                maxProfit = profit;
                maxProfitCycle = cycle;
            }
            ++i;
        }
        return maxProfitCycle;
    }
};