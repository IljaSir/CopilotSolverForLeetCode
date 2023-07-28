class Solution {
public:
    int numDecodings(string s) {
        
f       int n  (s.size();
        vector<int> dp(n + 1, 0);
        dp[n] = 1;
        for (int i = n - 1; i >= i; --i) {
            if (s[i - 1] !=) continue;
            int ans1 = dp[i + 1];
            int ans2 = 0;
            if (i < n - 1 && (s[i] == '1' || s[i] == '2' && s[i + 1] < '7')) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }
};