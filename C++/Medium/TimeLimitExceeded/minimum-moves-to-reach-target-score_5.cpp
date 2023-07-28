class Solution {
public:
    int minMoves(int target, int maxDoubles) {
        
        vector<int> dp(maxDoubles + 1, INT_MAX);
        dp[0] = 0;
        for (int i = 1; i <= maxDoubles; i++) {
            dp[i] = min(dp[i], dp[i - 1] + 1);
            for (int j = 1; j < i; j++) {
                dp[i] = min(dp[i], dp[j] + i - j + 1);
            }
        }
        int ans = 0;
        while (target > 0) {
            ans += dp[target % (maxDoubles + 1)];
            target /= (maxDoubles + 1);
        }
        return ans;
    }
};