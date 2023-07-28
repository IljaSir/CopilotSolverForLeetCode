class Solution {
public:
    bool canConvertString(string s, string t, int k) {
        
        if (s.size() != t.size()) {
            return false;
        }
        vector<int> moves(26, 0);
        for (int i = 0; i < s.size(); ++i) {
            int diff = t[i] - s[i];
            if (diff < 0) {
                diff += 26;
            }
            if (diff != 0) {
                ++moves[diff];
            }
        }
        for (int i = 1; i < 26; ++i) {
            if (moves[i] * 26 + i > k) {
                return false;
            }
        }
        return true;
    }
};