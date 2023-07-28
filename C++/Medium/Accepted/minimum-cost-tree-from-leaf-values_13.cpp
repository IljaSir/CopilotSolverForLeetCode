class Solution {
public:
    int mctFromLeafValues(vector<int>& arr) {
        
        int n = arr.size();
        int dp[n][n];
        int m[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    m[i][j] = arr[i];
                } else {
                    m[i][j] = max(m[i][j-1], arr[j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j+i] = INT_MAX;
                for (int k = j; k < j+i; k++) {
                    dp[j][j+i] = min(dp[j][j+i], dp[j][k] + dp[k+1][j+i] + m[j][k] * m[k+1][j+i]);
                }
            }
        }
        return dp[0][n-1];
    }
};