class Solution {
public:
    int numberOfCombinations(string num) {
        
        int n = num.size();
        vector<int> dp(n + 1);
        dp[0] = 1;
        dp[1] = num[0] == '0' ? 0 : 1;
        for (int i = 2; i <= n; ++i) {
            if (num[i - 1] != '0') {
                dp[i] = dp[i - 1];
            }
            if (num[i - 2] != '0' && stoi(num.substr(i - 2, 2)) <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000007;
            }
        }
        return dp[n];
    }
    int numberOfWays(string num) {
        int n = num.size();
        vector<int> dp(n + 1);
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j >= 1; --j) {
                string s = num.substr(j - 1, i - j + 1);
                if (s[0] == '0') {
                    break;
                }
                if (stoi(s) <= 26) {
                    dp[i] = (dp[i] + dp[j - 1]) % 1000000007;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            ans = (ans + (long long)dp[i] * numberOfCombinations(num.substr(i))) % 1000000007;
        }
        return ans;
    }
};