class Solution {
public:
    int minimumDistance(string word) {
        
        int dp[27][27];
        memset(dp, 0x3f, sizeof(dp));
        dp[0][0] = 0;
        for (char c : word) {
            int cur = c - 'A' + 1;
            int tdp[27][27];
            memset(tdp, 0x3f, sizeof(tdp));
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    if (dp[i][j] == 0x3f3f3f3f) continue;
                    int d1 = dist(i, cur);
                    int d2 = dist(j, cur);
                    tdp[cur][j] = min(tdp[cur][j], dp[i][j] + d1);
                    tdp[i][cur] = min(tdp[i][cur], dp[i][j] + d2);
                    tdp[i][j] = min(tdp[i][j], dp[i][j] + d1 + d2);
                }
            }
            memcpy(dp, tdp, sizeof(dp));
        }
        int ans = 0x3f3f3f3f;
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                ans = min(ans, dp[i][j]);
            }
        }
        return ans;
    }
};