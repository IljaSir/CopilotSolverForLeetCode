class Solution {
public:
    int lastStoneWeightII(vector<int>& stones) {
        
        int n = stones.size();
        int sum = accumulate(stones.begin(), stones.end(), 0);
        int target = sum / 2;
        vector<vector<int>> dp(n, vector<int>(target + 1, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0) {
                    dp[i][j] = stones[i] == j ? stones[i] : 0;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= stones[i]) {
                        dp[i][j] = max(dp[i][j], dp[i - 1][j - stones[i]] + stones[i]);
                    }
                }
            }
        }
        return sum - 2 * dp[n - 1][target];
    }
};