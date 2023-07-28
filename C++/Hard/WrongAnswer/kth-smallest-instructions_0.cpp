class Solution {
public:
    string kthSmallestPath(vector<int>& destination, int k) {
        
        int row = destination[0];
        int col = destination[1];
        vector<vector<int>> dp(row+1, vector<int>(col+1, 0));
        dp[0][0] = 1;
        for (int i=1; i<=row; i++) {
            dp[i][0] = 1;
        }
        for (int j=1; j<=col; j++) {
            dp[0][j] = 1;
        }
        for (int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        string res;
        int r = row;
        int c = col;
        while (r > 0 || c > 0) {
            if (r == 0) {
                res += 'H';
                c--;
            } else if (c == 0) {
                res += 'V';
                r--;
            } else {
                if (k <= dp[r-1][c]) {
                    res += 'V';
                    r--;
                } else {
                    k -= dp[r-1][c];
                    res += 'H';
                    c--;
                }
            }
        }
        return res;
    }
};