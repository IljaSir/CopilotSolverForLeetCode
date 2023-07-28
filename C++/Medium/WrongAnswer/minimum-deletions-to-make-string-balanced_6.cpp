class Solution {
public:
    int minimumDeletions(string s) {
        
        int n = s.size();
        vector<int> dp(n+1, 0);
        dp[0] = s[0] == 'a' ? 1 : 0;
        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i-1] + (s[i] == 'a' ? 1 : 0);
        }
        int ans = n;
        for (int i = 0; i < n; ++i) {
            int cur = dp[i] + (n - i - 1 - (s[i] == 'a' ? 1 : 0));
            ans = min(ans, cur);
        }
        return ans;
    }
};