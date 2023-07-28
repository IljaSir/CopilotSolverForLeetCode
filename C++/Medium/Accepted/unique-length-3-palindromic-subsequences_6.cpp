class Solution {
public:
    int countPalindromicSubsequence(string s) {
        
        int i, j, k, n = s.size();
        int ans = 0;
        for (i = 0; i < 26; i++) {
            int l = -1, r = -1;
            for (j = 0; j < n; j++) {
                if (s[j] == 'a' + i) {
                    l = j;
                    break;
                }
            }
            for (j = n - 1; j >= 0; j--) {
                if (s[j] == 'a' + i) {
                    r = j;
                    break;
                }
            }
            if (l == r) continue;
            int cnt[26] = {};
            for (j = l + 1; j < r; j++) {
                cnt[s[j] - 'a']++;
            }
            for (j = 0; j < 26; j++) {
                if (cnt[j]) ans++;
            }
        }
        return ans;
    }
};