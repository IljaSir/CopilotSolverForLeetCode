class Solution {
public:
    int countVowelSubstrings(string word) {
        
        int n = word.size();
        vector<vector<int>> dp(n, vector<int>(5, 0));
        for (int i = 0; i < n; i++) {
            int c = word[i] - 'a';
            dp[i][c]++;
            for (int j = 0; j < 5; j++) {
                if (j > c) break;
                if (i > 0) dp[i][j] += dp[i-1][j];
            }
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) sum += dp[n-1][i];
        return sum;
    }
};