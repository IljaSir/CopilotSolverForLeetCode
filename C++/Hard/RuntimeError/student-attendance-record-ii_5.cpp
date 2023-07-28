class Solution {
public:
    int checkRecord(int n) {
        
        vector<long> dp(n+1, 0);
        dp[0] = 1; // 0 absent
        dp[1] = 2; // 0 absent, 1 absent
        dp[2] = 4; // 0 absent, 1 absent, 2 absent
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            dp[i] %= 1000000007;
        }
        long res = dp[n];
        for (int i = 0; i < n; i++) {
            res += dp[i] * dp[n-1-i];
            res %= 1000000007;
        }
        return res;
    }
};