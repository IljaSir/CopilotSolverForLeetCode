class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        
        int n = s.size();
        if (s[n - 1] == '1') return false;
        vector<bool> dp(n, false);
        dp[0] = true;
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            if (i - minJump >= 0) {
                if (dp[i - minJump]) {
                    left = i - minJump;
                }
            }
            if (i - maxJump - 1 >= 0) {
                if (dp[i - maxJump - 1]) {
                    right = i - maxJump - 1;
                }
            }
            if (left <= right && s[i] == '0') {
                dp[i] = true;
            }
        }
        return dp[n - 1];
    }
};