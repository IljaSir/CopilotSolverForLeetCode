class Solution {
public:
    int rearrangeCharacters(string s, string target) {
        
        int n = s.length();
        int m = target.length();
        if (n < m) return 0;
        int cnt[26] = {0};
        for (char c : s) cnt[c - 'a']++;
        for (char c : target) cnt[c - 'a']--;
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] < 0) return 0;
        }
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < n && j < m) {
            if (s[i] == target[j]) {
                ++i;
                ++j;
            } else {
                ++i;
            }
            if (j == m) {
                j = 0;
                ++res;
            }
        }
        return res;
    }
};