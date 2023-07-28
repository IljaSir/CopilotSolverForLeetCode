class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        
        int n = s.size();
        if (n == 1) return true;
        if (s[n - 1] == '1') return false;
        vector<bool> dp(n, false);
        dp[0] = true;
        vector<int> sum(n + 1, 0);
        sum[1] = 1;
        for (int i = 1; i < n; ++i) {
            if (s[i] == '1') continue;
            int l = i - maxJump, r = i - minJump;
            if (l < 0) l = 0;
            if (r < 0) r = 0;
            if (sum[r + 1] - sum[l] > 0) dp[i] = true;
            sum[i + 1] = sum[i] + dp[i];
        }
        return dp[n - 1];
    }
};