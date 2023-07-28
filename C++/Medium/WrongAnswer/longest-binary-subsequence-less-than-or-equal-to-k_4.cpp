class Solution {
public:
    int longestSubsequence(string s, int k) {
        
        int n = s.size();
        vector<int> dp(n, 0);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') continue;
            dp[i] = 1;
            int sum = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s[j] == '0') continue;
                if (sum + dp[j] > k) break;
                sum += dp[j];
                dp[i] = max(dp[i], sum);
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};