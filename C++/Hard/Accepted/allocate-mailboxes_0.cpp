class Solution {
public:
    int minDistance(vector<int>& houses, int k) {
        
        int n = houses.size();
        sort(houses.begin(), houses.end());
        vector<vector<int>> cost(n, vector<int>(n));
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int mid = (i + j) / 2;
                for (int k = i; k <= j; ++k) {
                    cost[i][j] += abs(houses[k] - houses[mid]);
                }
            }
        }
        vector<vector<int>> dp(n, vector<int>(k));
        for (int i = 0; i < n; ++i) {
            dp[i][0] = cost[0][i];
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < k; ++j) {
                dp[i][j] = INT_MAX;
                for (int m = j - 1; m < i; ++m) {
                    dp[i][j] = min(dp[i][j], dp[m][j - 1] + cost[m + 1][i]);
                }
            }
        }
        return dp[n - 1][k - 1];
    }
};