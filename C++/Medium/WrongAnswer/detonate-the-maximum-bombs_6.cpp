class Solution {
public:
    int maximumDetonation(vector<vector<int>>& bombs) {
        
        int n = bombs.size();
        vector<vector<int>> g(n, vector<int>(n));
        vector<int> dp(1<<n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int dx = bombs[i][0] - bombs[j][0];
                int dy = bombs[i][1] - bombs[j][1];
                int d = dx * dx + dy * dy;
                if (d <= bombs[i][2] * bombs[i][2]) {
                    g[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < (1<<n); i++) {
            for (int j = 0; j < n; j++) {
                if (i & (1<<j)) {
                    for (int k = 0; k < n; k++) {
                        if (g[j][k] && i & (1<<k)) {
                            dp[i] = max(dp[i], dp[i ^ (1<<k)] + 1);
                        }
                    }
                }
            }
        }
        return dp[(1<<n) - 1];
    }
};