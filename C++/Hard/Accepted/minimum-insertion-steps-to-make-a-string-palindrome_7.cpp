class Solution {
public:
    int minInsertions(string s) {
        
        int size = s.size();
        vector<vector<int>> dp(size, vector<int>(size, 0));
        for (int i = size - 1; i >= 0; i--) {
            for (int j = i + 1; j < size; j++) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][size - 1];
    }
};