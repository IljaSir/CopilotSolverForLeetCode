class Solution {
public:
    bool rotateString(string s, string goal) {
        
        if (s.length() != goal.length()) return false;
        if (s == goal) return true;
        int n = s.length();
        for (int i = 1; i < n; ++i) {
            if (s[i] == goal[0]) {
                bool flag = true;
                for (int j = 0; j < n; ++j) {
                    if (s[(i + j) % n] != goal[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }
};