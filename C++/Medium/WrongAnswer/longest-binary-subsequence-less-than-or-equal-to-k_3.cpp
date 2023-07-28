class Solution {
public:
    int longestSubsequence(string s, int k) {
        
        int n = s.size();
        vector<int> dp(n, 0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '1') {
                dp[i] = 1;
                if (i > 0) {
                    dp[i] += dp[i-1];
                }
            }
            if (dp[i] <= k) {
                ans = max(ans, dp[i]);
            }
        }
        return ans;
    }
};