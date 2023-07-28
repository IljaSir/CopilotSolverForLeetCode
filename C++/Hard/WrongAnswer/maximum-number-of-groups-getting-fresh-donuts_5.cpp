class Solution {
public:
    int maxHappyGroups(int batchSize, vector<int>& groups) {
        
        int n = groups.size();
        vector<int> cnt(batchSize);
        int res = 0;
        for (auto g : groups) {
            if (g % batchSize == 0) {
                ++res;
            } else {
                ++cnt[g % batchSize];
            }
        }
        vector<vector<int>> dp(batchSize, vector<int>(1 << n, -1));
        dp[0][0] = 0;
        for (int mask = 0; mask < (1 << n); ++mask) {
            for (int i = 0; i < batchSize; ++i) {
                if (dp[i][mask] == -1) continue;
                for (int j = 0; j < n; ++j) {
                    if ((mask >> j) & 1) continue;
                    int ni = (i + groups[j]) % batchSize;
                    int nmask = mask | (1 << j);
                    dp[ni][nmask] = max(dp[ni][nmask], dp[i][mask] + (ni == 0));
                }
            }
        }
        int ans = res;
        for (int i = 1; i < batchSize; ++i) {
            ans = max(ans, res + dp[i][(1 << n) - 1]);
        }
        return ans;
    }
};