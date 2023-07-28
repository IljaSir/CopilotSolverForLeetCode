class Solution {
public:
    int numberOfWays(string corridor) {
        
        int n = corridor.length();
        int M = 1e9 + 7;
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        dp[1] = 1;
        int j = 0;
        int k = 0;
        for(int i = 1; i < n; i++) {
            if(corridor[i] == 'S') {
                if(corridor[i - 1] == 'S') {
                    dp[i + 1] = dp[i] + dp[i - 1];
                }
                else {
                    dp[i + 1] = dp[i];
                }
            }
            else {
                if(corridor[i - 1] == 'S') {
                    dp[i + 1] = dp[i - 1];
                }
                else {
                    dp[i + 1] = 0;
                }
            }
            dp[i + 1] = dp[i + 1] % M;
        }
        return dp[n];
    }
};