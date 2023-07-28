class Solution {
public:
    bool canConvertString(string s, string t, int k) {
        
        if (s.length() != t.length()) return false;
        vector<int> count(26, 0);
        for (int i = 0; i < s.length(); i++) {
            int diff = (t[i] - s[i] + 26) % 26;
            if (diff) count[diff]++;
        }
        for (int i = 1; i < 26; i++) {
            if (count[i] * 26 + i > k) return false;
        }
        return true;
    }
};