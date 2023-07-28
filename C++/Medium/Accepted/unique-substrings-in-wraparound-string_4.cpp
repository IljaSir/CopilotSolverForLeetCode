class Solution {
public:
    int findSubstringInWraproundString(string s) {
        
        int n = s.size();
        if (n == 0) return 0;
        vector<int> dp(26, 0);
        int len = 1;
        for (int i = 0; i < n; i++) {
            int cur = s[i] - 'a';
            if (i > 0 && (s[i] - s[i - 1] == 1 || s[i - 1] - s[i] == 25)) {
                len++;
            } else {
                len = 1;
            }
            dp[cur] = max(dp[cur], len);
        }
        return accumulate(dp.begin(), dp.end(), 0);
    }
};