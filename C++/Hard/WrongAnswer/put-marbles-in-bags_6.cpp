class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        
        long long n = weights.size();
        vector<long long> prefix(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + weights[i];
        }
        vector<vector<long long>> dp(k, vector<long long>(n, INT_MAX));
        for (int i = 0; i < n; ++i) {
            dp[0][i] = prefix[i + 1];
        }
        for (int i = 1; i < k; ++i) {
            for (int j = i; j < n; ++j) {
                for (int p = i - 1; p < j; ++p) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][p] + prefix[j + 1] - prefix[p + 1]);
                }
            }
        }
        return dp[k - 1][n - 1];
    }
    int minimumIncompatibility(vector<int>& nums, int k) {
        int n = nums.size();
        if (n % k != 0) {
            return -1;
        }
        int m = n / k;
        sort(nums.begin(), nums.end());
        long long ans = 0;
        for (int i = 0; i < k; ++i) {
            vector<int> weights;
            for (int j = 0; j < m; ++j) {
                weights.push_back(nums[i * m + j]);
            }
            ans += putMarbles(weights, m);
        }
        return ans;
    }
};