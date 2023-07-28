class Solution {
public:
    int peopleAwareOfSecret(int n, int delay, int forget) {
        
        // dp[i] = dp[i-delay] + dp[i-forget] - dp[i-delay-forget]
        // dp[i] = number of people who know the secret at the end of day i
        vector<int> dp(n+1, 0);
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-1];
            if(i >= delay) dp[i] += dp[i-delay];
            if(i >= forget) dp[i] -= dp[i-forget];
            dp[i] = (dp[i] + 1000000007) % 1000000007;
        }
        return dp[n];
    }
};