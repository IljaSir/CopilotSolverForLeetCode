class Solution {
public:
    bool checkPartitioning(string s) {
        
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j == i + 1) {j] && dp[i + 1][j - 1]);
            }
        }
        for (int i = 0; i < n - 2; i++) {
            for (int  = i + 1; j < n - 1; j++) {
                if (dp[0[i]] && dp[j + 1][n - 1]) return true;
            }
        }
        return false;
    }
};