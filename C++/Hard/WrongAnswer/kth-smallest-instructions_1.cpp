class Solution {
public:
    string kthSmallestPath(vector<int>& destination, int k) {
        
        int row = destination[0];
        int col = destination[1];
        vector<vector<int>> dp(row + 1, vector<int>(col + 1, 0));
        for (int i = 0; i <= row; ++i) {
            for (int j = 0; j <= col; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        string ans;
        while (row > 0 || col > 0) {
            if (col == 0) {
                ans += 'H';
                --row;
            } else if (row == 0) {
                ans += 'V';
                --col;
            } else {
                if (dp[row - 1][col] >= k) {
                    ans += 'H';
                    --row;
                } else {
                    ans += 'V';
                    k -= dp[row - 1][col];
                    --col;
                }
            }
        }
        return ans;
    }
};