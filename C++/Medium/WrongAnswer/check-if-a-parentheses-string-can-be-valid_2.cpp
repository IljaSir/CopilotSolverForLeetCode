class Solution {
public:
    bool canBeValid(string s, string locked) {
        
        int n = s.size();
        int open = 0;
        int close = 0;
        for (int i = 0; i < n; ++i) {
            if (locked[i] == '0') {
                if (s[i] == '(') {
                    ++open;
                } else {
                    ++close;
                }
            }
        }
        if (close > open) {
            return false;
        }
        int left = 0;
        for (int i = 0; i < n; ++i) {
            if (locked[i] == '0') {
                if (s[i] == '(') {
                    ++left;
                } else {
                    --left;
                }
            }
            if (left < 0) {
                return false;
            }
        }
        return true;
    }
};