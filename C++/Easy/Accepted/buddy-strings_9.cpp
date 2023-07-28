class Solution {
public:
    bool buddyStrings(string s, string goal) {
        
        int diff = 0;
        int c1 = -1;
        int c2 = -1;
        int map[26] = {0};
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (s[i] != goal[i]) {
                if (diff == 0) {
                    c1 = i;
                } else if (diff == 1) {
                    c2 = i;
                } else {
                    return false;
                }
                ++diff;
            }
            ++map[s[i] - 'a'];
        }
        if (diff == 1) {
            return false;
        } else if (diff == 0) {
            for (int i = 0; i < 26; ++i) {
                if (map[i] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            return s[c1] == goal[c2] && s[c2] == goal[c1];
        }
    }
};