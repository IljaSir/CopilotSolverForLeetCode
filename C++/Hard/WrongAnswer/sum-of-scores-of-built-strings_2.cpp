class Solution {
public:
    long long sumScores(string s) {
        
        int n = s.size();
        vector<int> dp(n);
        int k = 0;
        for (int i = 1; i < n; ++i) {
            while (k > 0 && s[i] != s[k]) {
                k = dp[k - 1];
            }
            if (s[i] == s[k]) {
                ++k;
            }
            dp[i] = k;
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += dp[i];
        }
        return ans;
    }
};