class Solution {
public:
    int minFlipsMonoIncr(string s) {
        
        int n = s.size();
        vector<int> dp(n, 0);
        dp[0] = s[0] - '0';
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + s[i] - '0';
        }
        int ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            int left = i >= 1 ? dp[i - 1] : 0;
            int right = dp[n - 1] - dp[i];
            ans = min(ans, left + (n - i - right));
        }
        return min(ans, dp[n - 1]);
    }
};