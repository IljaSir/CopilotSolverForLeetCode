class Solution {
public:
    int numOfWays(vector<int>& nums) {
        
        int n = nums.size();
        long long mod = 1e9 + 7;
        vector<int> left(n), right(n);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[j] < nums[i]) {
                    ++left[i];
                } else {
                    ++right[i];
                }
            }
        }
        vector<vector<long long>> dp(n, vector<long long>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int k = 2; k <= n; ++k) {
            for (int i = 0; i <= n - k; ++i) {
                int j = i + k - 1;
                for (int m = i; m <= j; ++m) {
                    long long left_cnt = 1, right_cnt = 1;
                    if (m > i) {
                        left_cnt = dp[i][m - 1];
                        for (int t = i; t < m; ++t) {
                            left_cnt = left_cnt * dp[left[t]][m - 1] % mod;
                        }
                    }
                    if (m < j) {
                        right_cnt = dp[m + 1][j];
                        for (int t = m + 1; t <= j; ++t) {
                            right_cnt = right_cnt * dp[m + 1][right[t]] % mod;
                        }
                    }
                    dp[i][j] = (dp[i][j] + left_cnt * right_cnt) % mod;
                }
            }
        }
        return (dp[0][n - 1] - 1 + mod) % mod;
    }
};