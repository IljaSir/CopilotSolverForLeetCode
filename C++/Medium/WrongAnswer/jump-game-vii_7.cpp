class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        
        int n = s.size();
        vector<bool> dp(n, false);
        dp[0] = true;
        int start = 0, end = 0, sum = 0;
        for (int i = 1; i < n; i++) {
            if (i >= minJump) {
                sum -= dp[i - minJump];
            }
            if (i > maxJump) {
                sum += dp[i - maxJump - 1];
            }
            dp[i] = s[i] == '0' && sum > 0;
        }
        return dp[n - 1];
    }
};