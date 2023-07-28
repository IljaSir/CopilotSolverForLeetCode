class Solution {
public:
    long long maxProduct(string s) {
        
        int n = s.size();
        vector<int> dp(26, 0);
        for (int i = 0; i < n; i++) {
            dp[s[i] - 'a'] |= (1 << i);
        }
        long long ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                int x = dp[i], y = dp[j];
                if (x & y) continue;
                int len = __builtin_popcount(x) * __builtin_popcount(y);
                ans = max(ans, (long long)len);
            }
        }
        return ans;
    }
};