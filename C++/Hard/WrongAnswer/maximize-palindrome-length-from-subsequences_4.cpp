class Solution {
public:
    int longestPalindrome(string word1, string word2) {
        
        string s = word1 + word2;
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for(int i = 0; i < n; i++) dp[i][i] = 1;
        int ans = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                if(s[i] == s[j]) dp[i][j] = dp[i+1][j-1] + 2;
                else dp[i][j] = max(dp[i+1][j], dp[i][j-1]);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(s[i] == s[j]) ans = max(ans, dp[i+1][j-1] + 2);
            }
        }
        return ans;
    }
};