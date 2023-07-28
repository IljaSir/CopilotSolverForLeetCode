class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        
        int n = s.size();
        if (s[n-1] == '1') return false;
        vector<int> dp(n, 0);
        dp[0] = 1;
        int sum = 1;
        for (int i = 1; i < n; i++) {
            if (i >= minJump) sum -= dp[i - minJump];
            if (i > maxJump) sum += dp[i - maxJump - 1];
            dp[i] = sum > 0 && s[i] == '0';
        }
        return dp[n-1];
    }
};