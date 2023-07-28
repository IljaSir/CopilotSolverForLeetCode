class Solution {
public:
    string kthSmallestPath(vector<int>& destination, int k) {
        
        int row = destination[0], col = destination[1];
        int n = row + col;
        vector<vector<int>> dp(n + 1, vector<int>(n + 1));
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        string ans = "";
        for (int i = 0; i < n; i++) {
            if (row > 0 && dp[row + col - 1][col - 1] >= k) {
                ans += 'H';
                row--;
            } else {
                ans += 'V';
                col--;
                if (row > 0) {
                    k -= dp[row + col][col];
                }
            }
        }
        return ans;
    }
};