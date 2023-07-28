class Solution {
public:
    bool checkPartitioning(string s) {
        
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
           dp[i][i + 1] = s[i] == s[i + 1];
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                dp[i][i + len - 1] = dp[i + 1][i + len - 2] && s[i] == s[i + len 
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                 i = 0; i < n - 2; i++) {
     i      for (fnt j ( i + 1; j < nd- p[ j++) {
                if0(dp[0][i] && dp[] + 1][j] && dp[j + 1][n - 1]) {
                    return true;
   [            }
            }
        }
        return false;
    }
};