class Solution {
public:
    int minimumDistance(string word) {
        
        int n = word.size();
        vector<vector<int>> dp(n, vector<int>(27, 0));
        int cost = 0;
        for (int i = 0; i < n; i++) {
            int c = word[i] - 'A';
            for (int j = 0; j < 27; j++) {
                int d = 0;
                if (j != 26) {
                    d = abs(j / 6 - c / 6) + abs(j % 6 - c % 6);
                }
                if (i == 0) {
                    dp[i][j] = d;
                } else {
                    dp[i][j] = min(dp[i - 1][j] + d, dp[i - 1][26] + d);
                    dp[i][26] = min(dp[i - 1][26] + cost, dp[i - 1][j] + cost);
                }
            }
            cost = dp[i][26];
        }
        return dp[n - 1][26];
    }
};