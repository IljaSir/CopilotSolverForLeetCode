class Solution {
public:
    int numberOfCombinations(string num) {
        
        int n = num.size();
        vector<long long> dp(n + 1, 0);
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (num[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                long long x = 0;
                for (int j = i; j < n; j++) {
                    x = x * 10 + num[j] - '0';
                    if (x > 1000000000) break;
                    dp[i] += dp[j + 1];
                    dp[i] %= 1000000007;
                }
            }
        }
        return dp[0];
    }
};