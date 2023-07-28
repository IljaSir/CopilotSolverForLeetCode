class Solution {
public:
    int maxJump(vector<int>& stones) {
        
        int n = stones.size();
        vector<vector<int>> dp(n, vector<int>(n, INT_MAX));
        dp[0][0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = lower_bound(stones.begin(), stones.end(), stones[i] - stones[j]) - stones.begin();
                for (int p = k; p < i; ++p) {
                    dp[i][j] = min(dp[i][j], dp[p][j] + stones[i] - stones[p]);
                    dp[i][i] = min(dp[i][i], dp[p][j] + stones[i] - stones[j]);
                }
            }
        }
        return *min_element(dp[n - 1].begin(), dp[n - 1].end());
    }
};