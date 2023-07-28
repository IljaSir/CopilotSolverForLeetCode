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
            dp[0][i] = sum[i + 1] * (i + 1) - sum[0];
        }
        for (int i = 1; i < k; ++i) {
            for (int j = i; j < n; ++j) {
                dp[i][j] = LLONG_MAX;
                for (int p = i - 1; p < j; ++p) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][p] + (sum[j + 1] - sum[p + 1]) * (j - p));
                }
            }
        }
        return dp[k - 1][n - 1];
    }
    int minimumIncompatibility(vector<int>& nums, int k) {
        int n = nums.size();
        if (n % k) return -1;
        unordered_map<int, int> cnt;
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] > k) return -1;
        }
        vector<int> weights;
        for (auto& [num, count] : cnt) {
            weights.push_back(num);
        }
        return putMarbles(weights, k);
    }
};