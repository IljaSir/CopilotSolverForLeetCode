class Solution {
public:
    int maxHappyGroups(int batchSize, vector<int>& groups) {
        
        int n = groups.size();
        vector<int> cnt(batchSize);
        for (auto& g : groups) {
            cnt[g % batchSize]++;
        }
        vector<vector<int>> dp(1 << n, vector<int>(batchSize, -1));
        dp[0][0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            for (int r = 0; r < batchSize; r++) {
                if (dp[mask][r] == -1) continue;
                for (int i = 0; i < n; i++) {
                    if (mask & (1 << i)) continue;
                    int nmask = mask | (1 << i);
                    int nr = (r + groups[i]) % batchSize;
                    dp[nmask][nr] = max(dp[nmask][nr], dp[mask][r] + (nr == 0 ? 1 : 0));
                }
            }
        }
        return dp[(1 << n) - 1][0] + cnt[0];
    }
};