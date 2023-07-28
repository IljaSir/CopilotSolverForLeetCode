class Solution {
public:
    int minimumDistance(string word) {
        
        int dp[27][27][27][27];
        memset(dp, 0x3f, sizeof(dp));
        dp[0][0][0][0] = 0;
        for (int i = 0; i < word.size(); ++i) {
            int c = word[i] - 'A';
            for (int f1 = 0; f1 < 27; ++f1) {
                for (int f2 = 0; f2 < 27; ++f2) {
                    for (int f3 = 0; f3 < 27; ++f3) {
                        for (int f4 = 0; f4 < 27; ++f4) {
                            int cost = dp[f1][f2][f3][f4] + dist(f1, f2, c);
                            dp[c][f2][f3][f4] = min(dp[c][f2][f3][f4], cost);
                            dp[f1][c][f3][f4] = min(dp[f1][c][f3][f4], cost);
                            dp[f1][f2][c][f4] = min(dp[f1][f2][c][f4], cost);
                            dp[f1][f2][f3][c] = min(dp[f1][f2][f3][c], cost);
                        }
                    }
                }
            }
        }
        int ans = 0x3f3f3f3f;
        for (int f1 = 0; f1 < 27; ++f1) {
            for (int f2 = 0; f2 < 27; ++f2) {
                for (int f3 = 0; f3 < 27; ++f3) {
                    for (int f4 = 0; f4 < 27; ++f4) {
                        ans = min(ans, dp[f1][f2][f3][f4]);
                    }
                }
            }
        }
        return ans;
    }
};