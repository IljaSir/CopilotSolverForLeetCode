class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        
        int n = s.length();
        vector<bool> dp(n, false);
        dp[0] = true;
        int left = 0, right = 0;
        for (int i = 1; i < n; ++i) {
            if (s[i] == '1') continue;
            if (i >= minJump) left += dp[i - minJump];
            if (i > maxJump) left -= dp[i - maxJump - 1];
            dp[i] = left > 0;
        }
        return dp[n - 1];
    }
};