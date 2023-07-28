class Solution {
public:
    int minNumberOfHours(int initialEnergy, int initialExperience, vector<int>& energy, vector<int>& experience) {
        
        int n = energy.size();
        int dp[n][101][101];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 100; j++) {
                for (int k = 0; k <= 100; k++) {
                    dp[i][j][k] = INT_MAX;
                }
            }
        }
        dp[0][initialEnergy][initialExperience] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= 100; j++) {
                for (int k = 0; k <= 100; k++) {
                    if (dp[i][j][k] != INT_MAX) {
                        int e = j - energy[i];
                        int x = k + experience[i];
                        if (e > 0 && x > 0) {
                            dp[i + 1][e][x] = min(dp[i + 1][e][x], dp[i][j][k]);
                        }
                        dp[i][j + 1][k] = min(dp[i][j + 1][k], dp[i][j][k] + 1);
                        dp[i][j][k + 1] = min(dp[i][j][k + 1], dp[i][j][k] + 1);
                    }
                }
            }
        }
        int res = INT_MAX;
        for (int j = 0; j <= 100; j++) {
            for (int k = 0; k <= 100; k++) {
                if (dp[n - 1][j][k] != INT_MAX) {
                    int e = j - energy[n - 1];
                    int x = k + experience[n - 1];
                    if (e > 0 && x > 0) {
                        res = min(res, dp[n - 1][j][k]);
                    }
                }
            }
        }
        return res;
    }
};