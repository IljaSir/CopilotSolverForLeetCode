class Solution {
public:
    int maxHappyGroups(int batchSize, vector<int>& groups) {
        
        int n = groups.size();
        vector<int> cnt(batchSize);
        int ans = 0;
        for (int g : groups) {
            if (g % batchSize == 0) {
                ans++;
            } else {
                cnt[g % batchSize]++;
            }
        }
        vector<vector<int>> dp(batchSize, vector<int>(1 << n, -1));
        dp[0][0] = 0;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < batchSize; j++) {
                if (dp[j][i] == -1) continue;
                for (int k = 0; k < n; k++) {
                    if (i & (1 << k)) continue;
                    int nxt = (j + groups[k]) % batchSize;
                    dp[nxt][i | (1 << k)] = max(dp[nxt][i | (1 << k)], dp[j][i] + (nxt == 0));
                }
            }
        }
        return ans + dp[0][(1 << n) - 1];
    }
};