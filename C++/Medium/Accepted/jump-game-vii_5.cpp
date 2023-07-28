class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        
        int n = s.size();
        vector<bool> dp(n);
        dp[0] = true;
        int l = 0, r = 0, sum = 0;
        for (int i = 1; i < n; ++i) {
            if (i > maxJump) {
                sum -= dp[i - maxJump - 1];
            }
            if (i >= minJump) {
                sum += dp[i - minJump];
            }
            dp[i] = sum > 0 && s[i] == '0';
        }
        return dp[n - 1];
    }
};