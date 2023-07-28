class Solution {
public:
    int findRotateSteps(string ring, string key) {
        
        int n = ring.size();
        int m = key.size();
        vector<vector<int>> dp(m + 1, vector<int>(n, INT_MAX));
        // dp[i][j] represents the minimum steps of key[i:] and ring[j]
        for (int i = 0; i < n; i++) {
            dp[m][i] = 0;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (ring[k] == key[i]) {
                        int diff = abs(j - k);
                        int step = min(diff, n - diff);
                        dp[i][j] = min(dp[i][j], dp[i + 1][k] + step);
                    }
                }
            }
        }
        return dp[0][0] + m;
    }
};