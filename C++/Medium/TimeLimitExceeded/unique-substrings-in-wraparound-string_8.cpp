class Solution {
public:
    int findSubstringInWraproundString(string s) {
        
        int n = s.size();
        vector<int> dp(26, 0);
        int i = 0;
        int j = 0;
        while (i < n) {
            while (j < n && s[j] == (s[i] + j - i) % 26 + 'a') j++;
            int k = 0;
            while (i < j) {
                dp[s[i] - 'a'] = max(dp[s[i] - 'a'], j - i - k);
                i++;
                k++;
            }
        }
        return accumulate(dp.begin(), dp.end(), 0);
    }
};