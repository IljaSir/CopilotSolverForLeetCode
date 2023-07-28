class Solution {
public:
    bool canConvertString(string s, string t, int k) {
        
        if (s.length() != t.length()) return false;
        vector<int> m(26, 0);
        for (int i = 0; i < s.length(); i++) {
            int diff = t[i] - s[i];
            if (diff < 0) diff += 26;
            if (diff > 0) m[diff]++;
        }
        for (int i = 1; i <= k; i++) {
            if (m[i % 26] > 0) m[i % 26]--;
        }
        for (int i = 1; i < 26; i++) {
            if (m[i] > 0) return false;
        }
        return true;
    }
};