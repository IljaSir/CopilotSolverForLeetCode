class Solution {
public:
    int maxHappyGroups(int batchSize, vector<int>& groups) {
        
        vector<int> cnt(batchSize);
        int ans = 0;
        for (int g : groups) {
            if (g % batchSize == 0) {
                ans++;
            } else {
                cnt[g % batchSize]++;
            }
        }
        vector<vector<int>> dp(1 << groups.size(), vector<int>(batchSize));
        dp[0][0] = ans;
        for (int mask = 0; mask < (1 << groups.size()); mask++) {
            for (int i = 0; i < batchSize; i++) {
                for (int j = 0; j < groups.size(); j++) {
                    if (mask & (1 << j)) continue;
                    int nmask = mask | (1 << j);
                    int nrem = (i + groups[j]) % batchSize;
                    dp[nmask][nrem] = max(dp[nmask][nrem], dp[mask][i] + (nrem == 0 ? 1 : 0));
                }
            }
        }
        return dp[(1 << groups.size()) - 1][0];
    }
};