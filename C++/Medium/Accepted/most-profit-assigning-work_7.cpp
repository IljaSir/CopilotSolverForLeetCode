class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        
        int n = difficulty.size();
        int m = worker.size();
        vector<pair<int, int>> dp(n);
        for (int i = 0; i < n; i++) {
            dp[i] = {difficulty[i], profit[i]};
        }
        sort(dp.begin(), dp.end());
        sort(worker.begin(), worker.end());
        int res = 0;
        int maxProfit = 0;
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && dp[j].first <= worker[i]) {
                maxProfit = max(maxProfit, dp[j].second);
                j++;
            }
            res += maxProfit;
        }
        return res;
    }
};