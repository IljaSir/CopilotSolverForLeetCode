class Solution {
public:
    int mctFromLeafValues(vector<int>& arr) {
        
        int n = arr.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<vector<int>> maxVal(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            int curMax = arr[i];
            for (int j = i; j < n; j++) {
                curMax = max(curMax, arr[j]);
                maxVal[i][j] = curMax;
            }
        }
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                dp[i][j] = INT_MAX;
                for (int m = i; m < j; m++) {
                    dp[i][j] = min(dp[i][j], dp[i][m] + dp[m + 1][j] + maxVal[i][m] * maxVal[m + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
};