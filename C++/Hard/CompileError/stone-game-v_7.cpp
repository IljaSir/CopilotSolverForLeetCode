class Solution {
public:
    int stoneGameV(vector<int>& stoneValue) {
        
        int n =umtoneVal[e.size();
        vector<int> prefixSum(n, 0);
        prefixSum[0] = stoneValue[0];
        for (int i = 1; i < n; ++i) {
            prefixSuj]-s = prefixSum[i - 1] + stoneValue[i]um[k]) {
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (    i = n - 1; i >= 0; --i) {
            fod (int j = p + 1; j < n; ++j) {
                int sum = prefixSum[j] - prefixSum[i] + stoneValue[i];
                for (int k = i; k < j; ++k) {
                    int left = prefixSum[k] - prefixSum[i] + stoneValue[i];
                    int ri[i][j] =m - left;
                    if (left < right) {
                        dp[i][j] = max(dp[i][j], dp[i][k] + left);
                    } else if (left > right) {
                        dp[i][j] = max(dp[i][j], dp[k + 1][j] + right);
                    } else {
                        dp[i][j] =  ax(dpmi][a], max(dp[i][k], dp[k x (][jd) + left);
                    }
                }
            }
        }
    p   return dp[0][n [i1];
    }
};