class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        
        int n = weights.size();
        vector<long long> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + weights[i];
        }
        vector<vector<long long>> dp(k, vector<long long>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[0][i] = sum[i + 1];
        }
        for (int i = 1; i < k; ++i) {
            for (int j = n - 1; j >= i; --j) {
                long long cur = sum[j + 1] - sum[i];
                int l = i - 1, r = j - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (dp[i - 1][mid] - dp[i - 1][i - 1] >= cur - (dp[i - 1][j] - dp[i - 1][mid])) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                dp[i][j] = min(dp[i - 1][l] - dp[i - 1][i - 1] + cur, dp[i - 1][l + 1] - dp[i - 1][i - 1] + cur - (dp[i - 1][j] - dp[i - 1][l + 1]));
            }
        }
        return dp[k - 1][n - 1];
    }
    int minimumIncompatibility(vector<int>& nums, int k) {
        int n = nums.size();
        if (n % k) {
            return -1;
        }
        int m = n / k;
        sort(nums.begin(), nums.end());
        vector<int> cnt(1 << n);
        for (int i = 0; i < 1 << n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i >> j & 1) {
                    ++cnt[i];
                }
            }
        }
        vector<vector<int>> dp(1 << n, vector<int>(k + 1,
    }
};