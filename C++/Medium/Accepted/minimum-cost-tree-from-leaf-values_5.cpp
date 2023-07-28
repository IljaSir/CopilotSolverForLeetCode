class Solution {
public:
    int mctFromLeafValues(vector<int>& arr) {
        
        int N = arr.size();
        vector<vector<int>> dp(N, vector<int>(N, 0));
        vector<vector<int>> maxVal(N, vector<int>(N, 0));
        for (int i = 0; i < N; i++) {
            maxVal[i][i] = arr[i];
            for (int j = i+1; j < N; j++) {
                maxVal[i][j] = max(maxVal[i][j-1], arr[j]);
            }
        }
        for (int i = 0; i < N-1; i++) {
            dp[i][i+1] = arr[i] * arr[i+1];
        }
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < N-i; j++) {
                dp[j][j+i] = INT_MAX;
                for (int k = j; k < j+i; k++) {
                    dp[j][j+i] = min(dp[j][j+i], dp[j][k] + dp[k+1][j+i] + maxVal[j][k] * maxVal[k+1][j+i]);
                }
            }
        }
        return dp[0][N-1];
    }
};