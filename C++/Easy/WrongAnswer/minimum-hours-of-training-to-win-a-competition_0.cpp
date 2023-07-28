class Solution {
public:
    int minNumberOfHours(int initialEnergy, int initialExperience, vector<int>& energy, vector<int>& experience) {
        
        int n = energy.size();
        vector<vector<int>> dp(n + 1, vector<int>(initialEnergy + 1, INT_MAX));
        dp[0][initialEnergy] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= initialEnergy; j++) {
                if (dp[i][j] != INT_MAX) {
                    int e = max(j - energy[i], 1);
                    int ex = dp[i][j] + experience[i];
                    dp[i + 1][e] = min(dp[i + 1][e], ex);
                    dp[i + 1][j] = min(dp[i + 1][j], dp[i][j]);
                }
            }
        }
        int res = INT_MAX;
        for (int i = 1; i <= initialEnergy; i++) {
            if (dp[n][i] != INT_MAX) {
                res = min(res, dp[n][i]);
            }
        }
        return res - initialExperience;
    }
};