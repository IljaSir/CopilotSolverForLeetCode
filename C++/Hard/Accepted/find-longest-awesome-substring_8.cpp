class Solution {
public:
    int longestAwesome(string s) {
        
        int n = s.size();
        if (n < 2) return n;
        int res = 0;
        int dp[1024] = {0};
        for (int i = 0; i < 1024; ++i) dp[i] = n;
        dp[0] = -1;
        int mask = 0;
        for (int i = 0; i < n; ++i) {
            mask ^= 1 << (s[i] - '0');
            res = max(res, i - dp[mask]);
            for (int j = 0; j < 10; ++j) {
                int tmp = mask ^ (1 << j);
                res = max(res, i - dp[tmp]);
            }
            dp[mask] = min(dp[mask], i);
        }
        return res;
    }
};