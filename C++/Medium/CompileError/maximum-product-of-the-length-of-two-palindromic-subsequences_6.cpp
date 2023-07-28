class Solution {
public:
    int maxProduct(string s) {
        
        int n = s.length();
        vector<int> dp(1 << n, 0);
        for (int i = 0; i < (1 << n); ++i) {
            string t = "";
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    t += s[j];
                }
            }
            if (isPalindromic(t)) {
                dp[i] = t.length();
            }
        }
        int ans = 0;
        for (int i = 0; i < (1 << n); ++i) {
            for (int j = i + 1; j < (1 << n); ++j) {
                if ((i & j) == 0) {
                    ans = max(ans, dp[i] * dp[j]);
                }
            }
        }
        return ans;
    }
};