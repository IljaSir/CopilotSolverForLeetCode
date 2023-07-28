class Solution {
public:
    int countHousePlacements(int n) {
        
        // dp[i] = dp[i - 1] * 2 + dp[i - 2]
        if (n == 1) return 4;
        if (n == 2) return 9;
        int dp1 = 4;
        int dp2 = 9;
        int dp = 0;
        for (int i = 3; i <= n; i++) {
            dp = dp2 * 2 + dp1;
            dp1 = dp2;
            dp2 = dp;
        }
        return dp;
    }
};