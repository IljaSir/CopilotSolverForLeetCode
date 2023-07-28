class Solution {
public:
    bool canConvertString(string s, string t, int k) {
        
        if (s.size() != t.size()) return false;
        int n = s.size();
        vector<int> cnt(26, 0);
        for (int i = 0; i < n; ++i) {
            int diff = t[i] - s[i];
            if (diff < 0) diff += 26;
            if (diff) cnt[diff] += 1;
        }
        for (int i = 1; i < 26; ++i) {
            if (cnt[i] * 26 + i > k) return false;
        }
        return true;
    }
};