class Solution {
public:
    int countHomogenous(string s) {
        
        int n = s.size();
        vector<int> dp(n, 1);
        for (int i = 1; i < n; ++i) {
            if (s[i] == s[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = (ans + (1 + dp[i]) * dp[i] / 2) % 1000000007;
        }
        return ans;
    }
};