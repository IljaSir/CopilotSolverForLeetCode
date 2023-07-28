class Solution {
public:
    int maxHappyGroups(int batchSize, vector<int>& groups) {
        
        int n = groups.size();
        int b = batchSize;
        int mod[b];
        memset(mod, 0, sizeof(mod));
        for (int i = 0; i < n; i++) {
            mod[groups[i] % b]++;
        }
        int dp[1 << n][b];
        memset(dp, -1, sizeof(dp));
        dp[0][0] = 0;
        for (int m = 0; m < (1 << n); m++) {
            for (int i = 0; i < b; i++) {
                if (dp[m][i] == -1) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if ((m & (1 << j)) == 0) {
                        int x = (i + groups[j]) % b;
                        dp[m | (1 << j)][x] = max(dp[m | (1 << j)][x], dp[m][i] + (x == 0));
                    }
                }
            }
        }
        return dp[(1 << n) - 1][0] + mod[0];
    }
};