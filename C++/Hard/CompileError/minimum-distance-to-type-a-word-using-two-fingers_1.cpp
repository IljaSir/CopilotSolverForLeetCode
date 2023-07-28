class Solution {
public:
    int minimumDistance(string word) {
        
        int n = word.size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(27, vector<int>(27, INT_MAX)));
        dp[0][26][26] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int f1 = 0; f1 < 27; f1++) {
                for (int f2 = 0; f2 < 27; f2++) {
                    if (dp[i][f1][f2] == INT_MAX) continue;
                    int c1 = word[i] - 'A';
                    int c2 = word[i + 1] - 'A';
                    if (f1 == 26) {
                        dp[i + 1][c1][f2] = min(dp[i + 1][c1][f2], dp[i][f1][f2]);
                    } else {
                        dp[i + 1][c1][f2] = min(dp[i + 1][c1][f2], dp[i][f1][f2] + getDist(f1, c1));
                        dp[i + 1][f1][c2] = min(dp[i + 1][f1][c2], dp[i][f1][f2] + getDist(f2, c2));
                    }
                }
            }
        }
        int ans = INT_MAX;
        for (int f1 = 0; f1 < 27; f1++) {
            for (int f2 = 0; f2 < 27; f2++) {
                ans = min(ans, dp[n - 1][f1][f2]);
            }
        }
        return ans;
    }
};