class Solution {
public:
    int maxHappyGroups(int batchSize, vector<int>& groups) {
        
        int n = groups.size();
        int mod[batchSize];
        memset(mod, 0, sizeof(mod));
        for (int i = 0; i < n; i++) {
            mod[groups[i] % batchSize]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (groups[i] % batchSize == 0) {
                groups[i] = -1;
                ans++;
            }
        }
        int dp[batchSize][1 << n];
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < batchSize; i++) {
            for (int j = 0; j < (1 << n); j++) {
                if (i == 0) {
                    int cnt = 0;
                    for (int k = 0; k < n; k++) {
                        if ((j & (1 << k)) && groups[k] == -1) {
                            cnt++;
                        }
                    }
                    dp[i][j] = cnt;
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (groups[k] == -1) {
                        continue;
                    }
                    if (j & (1 << k)) {
                        dp[i][j] = max(dp[i][j], dp[(i + groups[k]) % batchSize][j ^ (1 << k)] + 1);
                    }
                }
            }
        }
        return ans + dp[0][(1 << n) - 1];
    }
};