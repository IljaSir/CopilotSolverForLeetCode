class Solution {
public:
    int shortestSequence(vector<int>& rolls, int k) {
        
        int n = rolls.size();
        vector<int> dp(n+1, 0);
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i-1] + rolls[i-1];
        }
        int ans = n;
        for (int i = 0; i <= n-k; ++i) {
            ans = min(ans, n - (dp[i+k] - dp[i]));
        }
        return ans;
    }
};