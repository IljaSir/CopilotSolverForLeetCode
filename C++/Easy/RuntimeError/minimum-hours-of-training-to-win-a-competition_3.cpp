class Solution {
public:
    int minNumberOfHours(int initialEnergy, int initialExperience, vector<int>& energy, vector<int>& experience) {
        
        int n = energy.size();
        vector<vector<int>> dp(n, vector<int>(n + 1, 1e9));
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] == 1e9) {
                    continue;
                }
                int e = initialEnergy + j;
                int exp = initialExperience + i - j;
                if (e > energy[i] && exp > experience[i]) {
                    dp[i + 1][j + 1] = min(dp[i + 1][j + 1], dp[i][j]);
                }
                dp[i][j + 1] = min(dp[i][j + 1], dp[i][j] + 1);
                dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + 1);
            }
        }
        int res = 1e9;
        for (int i = 0; i <= n; i++) {
            res = min(res, dp[n][i]);
        }
        return res;
    }
};