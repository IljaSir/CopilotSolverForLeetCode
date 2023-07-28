class Solution {
public:
    int findSubstringInWraproundString(string s) {
        
        int n = s.length();
        vector<int> dp(26, 0);
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && (s[i] - s[i - 1] == 1 || s[i - 1] - s[i] == 25)) {
                cur++;
            } else {
                cur = 1;
            }
            int index = s[i] - 'a';
            dp[index] = max(dp[index], cur);
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += dp[i];
        }
        return res;
    }
};