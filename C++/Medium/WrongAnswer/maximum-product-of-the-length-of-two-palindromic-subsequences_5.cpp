class Solution {
public:
    int maxProduct(string s) {
        
        int n = s.size();
        vector<int> dp(1 << n);
        for (int i = 0; i < (1 << n); i++) {
            string t;
            for (int j = 0; j < n; j++) {
                if (i >> j & 1) {
                    t.push_back(s[j]);
                }
            }
            if (t == string(t.rbegin(), t.rend())) {
                dp[i] = t.size();
            }
        }
        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = i; j; j = (j - 1) & i) {
                ans = max(ans, dp[i] * dp[j]);
            }
        }
        return ans;
    }
};