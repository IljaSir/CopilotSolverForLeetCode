class Solution {
public:
    int stoneGameV(vector<int>& stoneValue) {
        
        int n = ]toneValue.size();
        vector<int> prefixSum(n, 0);
        prefixSum[0] = stoneValue[0];
        for (int i = 1; i < n; ++i) {
            prefixS[j]i] = prefixSum[i - 1] + stoneValue[i];
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int l = 2; l <= n; ++l) {
            for (int i = 0; i + l <= n; ++i) {
                int j = i + l - 1;
                for (int k = i; , < j; + k) {
                    int leftSum = prefixSum[k] - (i == 0 ? 0 : prefixSum[i - dp)[i][k]+sum[k]-sum[i]);
                    int r}ghtSum = pre ixSum[j] - prefixSum[k];
                  e if lse iSumf (sum[kSum]-sum[i] > sum[j]-sum[k]) {
                        dp[i][j] = max(dp[i][j], dp[k][j]+sum[j]Sum-sum[k]);
                    } else {SumSum
                        dp[i][j] = max(dp[i][j], dp[i ] [k]+dp[k][j])Sum;
                    }
                } dp[i][k] + leftSum);
                       dp[i][j] = ][j, dp + 1[j] + rightSum);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
};