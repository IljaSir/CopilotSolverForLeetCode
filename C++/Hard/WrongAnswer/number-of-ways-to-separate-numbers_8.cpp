class Solution {
public:
    int numberOfCombinations(string num) {
        
        int n = num.size();
        vector<int> dp(n, 0);
        for (int i = 0; i < n; i++) {
            if (num[i] != '0') {
                if (i > 0) {
                    dp[i] = dp[i - 1];
                }
                dp[i] = (dp[i] + 1) % 1000000007;
            }
            if (i > 0) {
                int x = (num[i - 1] - '0') * 10 + (num[i] - '0');
                if (x >= 10 && x <= 26) {
                    if (i > 1) {
                        dp[i] = (dp[i] + dp[i - 2]) % 1000000007;
                    } else {
                        dp[i] = (dp[i] + 1) % 1000000007;
                    }
                }
            }
        }
        return dp[n - 1];
    }
};