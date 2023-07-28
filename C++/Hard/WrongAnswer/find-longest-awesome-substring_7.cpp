class Solution {
public:
    int longestAwesome(string s) {
        
        int n = s.size();
        vector<int> dp(n+1, 0);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] ^ (1 << (s[i-1] - '0'));
            res = max(res, i - 1);
            for (int j = 0; j < 10; j++) {
                res = max(res, i - 1 - (dp[i] ^ (1 << j)));
            }
            for (int j = 0; j < i; j++) {
                res = max(res, i - j - (dp[i] ^ dp[j]));
            }
        }
        return res;
    }
};