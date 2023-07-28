class Solution {
public:
    string kthSmallestPath(vector<int>& destination, int k) {
        
        int row = destination[0], column = destination[1];
        int n = row + column;
        vector<vector<long>> dp(n + 1, vector<long>(n + 1, 0));
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        string ans;
        for (int i = 0; i < n; i++) {
            if (row > 0) {
                if (dp[row + column - 1][row - 1] >= k) {
                    ans += 'H';
                    row--;
                }
                else {
                    ans += 'V';
                    column--;
                    k -= dp[row + column + 1][row];
                }
            }
            else {
                ans += 'V';
                column--;
            }
        }
        return ans;
    }
};