class Solution {
public:
    int distinctSubseqII(string s) {
        
        int n = s.size();
        vector<int> dp(n);
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            dp[i] = (dp[i - 1] << 1) % 1000000007;
            for (int j = 0; j < i; ++j) {
                if (s[i] == s[j]) {
                    dp[i] = (dp[i] - dp[j] + 1000000007) % 1000000007;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
};