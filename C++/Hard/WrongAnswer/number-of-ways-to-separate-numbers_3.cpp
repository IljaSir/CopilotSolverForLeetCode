class Solution {
public:
    int numberOfCombinations(string num) {
        
        int n = num.size();
        vector<long> dp(n + 1, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                int x = stoi(num.substr(j - 1, i - j + 1));
                if (x > 0 && x <= 26) {
                    dp[i] = (dp[i] + dp[j - 1]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
    int numberOfWays(string num) {
        int n = num.size();
        vector<long> dp(n + 1, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                int x = stoi(num.substr(j - 1, i - j + 1));
                if (x > 0 && x <= 26) {
                    dp[i] = (dp[i] + dp[j - 1]) % 1000000007;
                }
            }
        }
        return (dp[n] - 1 + 1000000007) % 1000000007;
    }
};