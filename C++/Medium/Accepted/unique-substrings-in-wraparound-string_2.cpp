class Solution {
public:
    int findSubstringInWraproundString(string s) {
        
        int n = s.size();
        int cnt[26] = {0};
        int maxLen = 0;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && (s[i] - s[i - 1] == 1 || s[i - 1] - s[i] == 25)) {
                ++maxLen;
            } else {
                maxLen = 1;
            }
            int index = s[i] - 'a';
            cnt[index] = max(cnt[index], maxLen);
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans += cnt[i];
        }
        return ans;
    }
};