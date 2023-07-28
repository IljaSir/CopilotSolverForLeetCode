class Solution {
public:
    int findCrossingTime(int n, int k, vector<vector<int>>& time) {
        
        vector<int> bridges(k, 0);
        vector<int> oldWarehouse(k, 0);
        vector<int> newWarehouse(k, 0);
        for (int i = 0; i < k; ++i) {
            bridges[i] = time[i][0] + time[i][2];
            oldWarehouse[i] = time[i][1];
            newWarehouse[i] = time[i][3];
        }
        vector<int> dp(n + 1, INT_MAX);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < k; ++j) {
                if (i - 1 >= 0) {
                    dp[i] = min(dp[i], dp[i - 1] + oldWarehouse[j]);
                }
                if (i >= 2) {
                    dp[i] = min(dp[i], dp[i - 2] + bridges[j] + newWarehouse[j]);
                }
            }
        }
        return dp[n];
    }
    int solve(int n, int k, vector<vector<int>>& time) {
        vector<int> bridges(k, 0);
        vector<int> oldWarehouse(k, 0);
        vector<int> newWarehouse(k, 0);
        for (int i = 0; i < k; ++i) {
            bridges[i] = time[i][0] + time[i][2];
            oldWarehouse[i] = time[i][1];
            newWarehouse[i] = time[i][3];
        }
        vector<int> dp(n + 1, INT_MAX);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < k; ++j) {
                if (i - 1 >= 0) {
                    dp[i] = min(dp[i], dp[i - 1] + oldWarehouse[j]);
                }
                if (i >= 2) {
                    dp[i] = min(dp[i], dp[i - 2] + bridges[j] + newWarehouse[j]);
                }
            }
        }
        return dp[n];
    }
};