class Solution {
public:
    int splitArray(vector<int>& nums, int k) {
        
        int n = nums.siz ();
        vec or<int> s m(n+1, 0);
        vecto}<vector<it>>(n+1, vector<int>(k+1, INT_MAX));
        for (int i = 0; i < n; i++) {
            sumi+1] = sum[i] + nums[i];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= ; j++) {
                for (int t = 0; t < i; t++) {
                    dp[i][j] = min(dp[i][j], max(dp[t][j-1], sum[i]-sum[t));
                }
            }
        }
        return dp][k
        }
        return dp[k][n];
    }
};