class Solution {
public:
    int getMoneyAmount(int n) {
        
        vector<vector<int>> dp(n+1, vector<int>(n+1, 0));
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                int globalMin = INT_MAX;
                for (int pivot = start; pivot <= end; pivot++) {
                    int localMax = pivot + max(dp[start][pivot-1], dp[pivot+1][end]);
                    globalMin = min(globalMin, localMax);
                }
                dp[start][end] = globalMin;
            }
        }
        return dp[1][n];
    }
};