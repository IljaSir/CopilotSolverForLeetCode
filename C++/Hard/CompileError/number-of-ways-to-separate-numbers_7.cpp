class Solution {
public:
    int numberOfCombinations(string num) {
        
        int n = num.size();
        long long int mod = 1e9 + 7;
        vector<long long int> dp(n + 1, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i - 1] * 10) % mod;
        }
        vector<long long int> pre(n + 1, 0);
        pre[0] = 0;
        for (int i = 1; i <= n; i++) {
            pre[i] = (pre[i - 1] * 10 + 1) % mod;
        }
        vector<long long int> dp2(n + 1, 0);
        dp2[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (num[j - 1] == '0') {
                    break;
                }
                long long int x = stoll(num.substr(j - 1, i - j + 1));
                if (x > 1e9) {
                    break;
                }
                dp2[i] = (dp2[i] + dp[i - j] * pre[j]) % mod;
            }
        }
        return dp2[n];
    }
    int numberOfCombinations(string num) {
        int n = num.size();
        long long int mod = 1e9 + 7;
        vector<long long int> dp(n + 1, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i - 1] * 10) % mod;
        }
        vector<long long int> pre(n + 1, 0);
        pre[0] = 0;
        for (int i = 1; i <= n; i++) {
            pre[i] = (pre[i - 1] * 10 + 1) % mod;
        }
        vector<long long int> dp2(n + 1, 0);
        dp2[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j
    }
};