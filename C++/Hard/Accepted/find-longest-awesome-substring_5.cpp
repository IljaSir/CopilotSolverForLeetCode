class Solution {
public:
    int longestAwesome(string s) {
        
        int n = s.length();
        vector<int> dp(1024, n);
        dp[0] = -1;
        int ans = 0, mask = 0;
        for (int i = 0; i < n; ++i) {
            mask ^= 1 << (s[i] - '0');
            ans = max(ans, i - dp[mask]);
            for (int j = 0; j < 10; ++j) {
                ans = max(ans, i - dp[mask ^ (1 << j)]);
            }
            dp[mask] = min(dp[mask], i);
        }
        return ans;
    }
};