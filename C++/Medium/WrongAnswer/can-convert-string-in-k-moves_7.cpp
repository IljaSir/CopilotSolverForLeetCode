class Solution {
public:
    bool canConvertString(string s, string t, int k) {
        
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        int cnt[26] = {0};
        for (int i = 0; i < n; ++i) {
            int diff = (t[i] - s[i] + 26) % 26;
            if (diff) {
                ++cnt[diff];
            }
        }
        for (int i = 1; i < 26; ++i) {
            if (cnt[i] > (k - i) / 26 + 1) {
                return false;
            }
        }
        return true;
    }
};