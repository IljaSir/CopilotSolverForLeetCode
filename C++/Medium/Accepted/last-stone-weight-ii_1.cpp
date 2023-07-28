class Solution {
public:
    int lastStoneWeightII(vector<int>& stones) {
        
        int sum = accumulate(stones.begin(), stones.end(), 0);
        int n = stones.size();
        int target = sum / 2;
        vector<vector<int>> dp(n + 1, vector<int>(target + 1, 0));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= stones[i - 1]) {
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - dp[n][target] * 2;
    }
};