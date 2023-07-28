class Solution {
public:
    int numberOfCombinations(string num) {
        
        int n = num.size();
        vector<long long> dp(n + 1, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] * 10 % 1000000007;
            if (i > 1 && num[i - 2] != '0') {
                int x = num[i - 2] - '0';
                int y = num[i - 1] - '0';
                if (x * 10 + y <= 26) {
                    dp[i] = (dp[i] + dp[i - 2]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
};