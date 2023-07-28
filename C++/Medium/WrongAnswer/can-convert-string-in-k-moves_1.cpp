class Solution {
public:
    bool canConvertString(string s, string t, int k) {
        
        if (s.size() != t.size()) return false;
        vector<int> cnt(26, 0);
        for (int i = 0; i < s.size(); ++i) {
            int diff = (t[i] - s[i] + 26) % 26;
            if (diff > 0) {
                cnt[diff]++;
            }
        }
        for (int i = 1; i < 26; ++i) {
            if (cnt[i] * 26 + i > k) return false;
        }
        return true;
    }
};