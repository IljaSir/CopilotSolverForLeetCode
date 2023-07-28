class Solution {
public:
    int minimumDistance(string word) {
        
        int n = word.size();
        vector<vector<int>> dp(n, vector<int>(27, INT_MAX));
        dp[0][26] = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                if (dp[i - 1][j] == INT_MAX) continue;
                dp[i][j] = min(dp[i][j], dp[i - 1][j] + dist(word[i - 1] - 'A', word[i] - 'A'));
                dp[i][word[i] - 'A'] = min(dp[i][word[i] - 'A'], dp[i - 1][j] + dist(j, word[i] - 'A'));
            }
        }
        return *min_element(dp[n - 1].begin(), dp[n - 1].end());
    }
};