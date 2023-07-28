class Solution {
public:
    int findSubstringInWraproundString(string s) {
        
        if (s.empty()) return 0;
        int n = s.size();
        vector<int> dp(26, 0);
        int cur = 1;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && (s[i] - 'a' == (s[i-1] - 'a' + 1) % 26)) {
                ++cur;
            } else {
                cur = 1;
            }
            dp[s[i] - 'a'] = max(dp[s[i] - 'a'], cur);
        }
        return accumulate(dp.begin(), dp.end(), 0);
    }
};