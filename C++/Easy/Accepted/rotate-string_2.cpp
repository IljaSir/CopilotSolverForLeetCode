class Solution {
public:
    bool rotateString(string s, string goal) {
        
        if (s.length() != goal.length()) return false;
        if (s.length() == 0) return true;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == goal[0]) {
                int j = 0;
                for (; j < goal.length(); j++) {
                    if (s[(i+j) % s.length()] != goal[j]) {
                        break;
                    }
                }
                if (j == goal.length()) return true;
            }
        }
        return false;
    }
};