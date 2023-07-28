class Solution {
public:
    int minNumberOfHours(int initialEnergy, int initialExperience, vector<int>& energy, vector<int>& experience) {
        
        int n = energy.size();
        vector<vector<int>> dp(n, vector<int>(initialEnergy + 1, -1));
        dp[0][initialEnergy] = initialExperience;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 1; j <= initialEnergy; ++j) {
                if (dp[i][j] == -1) continue;
                int k = min(j - 1, initialEnergy - energy[i]);
                dp[i + 1][k] = max(dp[i + 1][k], dp[i][j] + experience[i]);
            }
        }
        int ans = 0;
        for (int i = 1; i <= initialEnergy; ++i) {
            if (dp[n - 1][i] == -1) continue;
            ans = max(ans, (i - 1) * 2 + (initialEnergy - energy[n - 1] - i + 1));
        }
        return ans;
    }
};