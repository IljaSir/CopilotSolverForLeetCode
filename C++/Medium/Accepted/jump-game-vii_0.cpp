class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        
        int n = s.size();
        vector<bool> dp(n, false);
        dp[0] = true;
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i >= minJump) {
                l += dp[i - minJump];
            }
            if (i > maxJump) {
                l -= dp[i - maxJump - 1];
            }
            dp[i] = l > 0 && s[i] == '0';
        }
        return dp[n - 1];
    }
};