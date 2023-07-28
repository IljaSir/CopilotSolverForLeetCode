class Solution {
public:
    int numberOfCombinations(string num) {
        
        int n = num.size();
        vector<int> dp(n + 1);
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            if (num[i] != '0') {
                dp[i + 1] = dp[i];
            }
            if (i > 0 && num[i - 1] != '0') {
                int v = (num[i - 1] - '0') * 10 + (num[i] - '0');
                if (v <= 26) {
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
    int numberOfCombinations(string num) {
        int n = num.size();
        vector<int> dp(n + 1);
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            if (num[i] != '0') {
                dp[i + 1] = dp[i];
            }
            if (i > 0 && num[i - 1] != '0') {
                int v = (num[i - 1] - '0') * 10 + (num[i] - '0');
                if (v <= 26) {
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
};