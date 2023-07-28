class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        
        int N = s.size();
        if (s[N - 1] == '1') return false;
        vector<bool> dp(N, false);
        dp[0] = true;
        int left = 1, right = 1;
        for (int i = 1; i < N; ++i) {
            if (i >= minJump) left += dp[i - minJump];
            if (i > maxJump) left -= dp[i - maxJump - 1];
            dp[i] = s[i] == '0' && left > 0;
            right += dp[i];
        }
        return dp[N - 1];
    }
};