class Solution {
public:
    int maxJump(vector<int>& stones) {
        
        int n = stones.size();
        int maxJump = 0;
        int lastStone = stones[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (stones[i] + maxJump >= lastStone) {
                maxJump = lastStone - stones[i];
            } else {
                maxJump++;
            }
        }
        return maxJump;
    }
    int jump(vector<int>& stones) {
        int n = stones.size();
        int maxJump = maxJump(stones);
        int lastStone = stones[n - 1];
        vector<int> dp(n, 0);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = INT_MAX;
            for (int j = i - 1; j >= 0; j--) {
                if (stones[i] - stones[j] <= maxJump) {
                    if (dp[j] != INT_MAX) {
                        dp[i] = min(dp[i], dp[j] + 1);
                    }
                } else {
                    break;
                }
            }
        }
        return dp[n - 1];
    }
};