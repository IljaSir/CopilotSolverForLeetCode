class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        
        int n = costs.size();
        vector<vector<long long>> dp(k + 1, vector<long long>(n + 1, 0));
        for (int i = 1; i <= k; i++) {
            multiset<int> s;
            for (int j = 1; j <= n; j++) {
                s.insert(costs[j - 1]);
                if (j > candidates) {
                    s.erase(s.find(costs[j - candidates - 1]));
                }
                if (j >= i) {
                    dp[i][j] = dp[i - 1][j - candidates] + *s.begin();
                }
            }
        }
        return dp[k][n];
    }
};