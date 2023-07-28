class Solution {
public:
    int countPartitions(vector<int>& nums, int k) {
        
        int n = nums.size();
        int mod = 1000000007;
        // dp[i][j] 为前 i 个数分成 j 组的方案数
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, 0));
        // sum[i][j] 为前 i 个数分成 j 组的方案数之和
        vector<vector<int>> sum(n + 1, vector<int>(n + 1, 0));
        // pre[i][j] 为前 i 个数分成 j 组的方案数之和
        vector<vector<int>> pre(n + 1, vector<int>(n + 1, 0));
        // dp[i][j] = sum[i - 1][j - 1] - pre[i - 1][j - 1] + dp[i - 1][j]
        for (int i = 1; i <= n; ++i) {
            sum[i][1] = 1;
            pre[i][1] = 1;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 2; j <= i; ++j) {
                dp[i][j] = (sum[i - 1][j - 1] - pre[i - 1][j - 1] + dp[i - 1][j]) % mod;
                sum[i][j] = (sum[i - 1][j] + dp[i][j]) % mod;
                pre[i][j] = (pre[i - 1][j] + sum[i][j]) % mod;
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                int sum = 0;
                for (int k = j - 1; k < i; ++k) {
                    sum += nums[k];
                }
                if (sum >= k) {
                    ans = (ans + dp[i][j]) % mod;
                }
            }
        }
        return ans;
    }
};