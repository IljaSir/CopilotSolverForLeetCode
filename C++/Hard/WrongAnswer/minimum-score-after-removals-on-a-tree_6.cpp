class Solution {
public:
    int minimumScore(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<int> sum(1 << n);
        vector<int> cnt(1 << n);
        vector<int> dp(1 << n);
        for (int i = 0; i < (1 << n); ++i) {
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    sum[i] ^= nums[j];
                    ++cnt[i];
                }
            }
        }
        for (int i = 0; i < (1 << n); ++i) {
            dp[i] = sum[i];
        }
        for (int i = 0; i < (1 << n); ++i) {
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    dp[i] = min(dp[i], dp[i ^ (1 << j)]);
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 1; i < (1 << n); ++i) {
            if (cnt[i] == 1) {
                continue;
            }
            int j = ((1 << n) - 1) ^ i;
            for (int k = j; k; k = (k - 1) & j) {
                if (cnt[k] == 1) {
                    continue;
                }
                ans = min(ans, dp[k] ^ dp[i ^ k]);
            }
        }
        return ans;
    }
};