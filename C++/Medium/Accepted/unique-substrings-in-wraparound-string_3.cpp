class Solution {
public:
    int findSubstringInWraproundString(string s) {
        
        int n = s.size();
        if (n == 0) return 0;
        vector<int> dp(26, 0);
        int count = 1;
        dp[s[0] - 'a'] = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] - s[i - 1] == 1 || s[i - 1] - s[i] == 25) {
                count++;
            } else {
                count = 1;
            }
            dp[s[i] - 'a'] = max(dp[s[i] - 'a'], count);
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += dp[i];
        }
        return res;
    }
};