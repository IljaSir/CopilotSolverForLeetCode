class Solution {
public:
    bool canBeValid(string s, string locked) {
        
        int n = s.size();
        int l = 0;
        for (int i = 0; i < n; ++i) {
            if (locked[i] == '0') {
                if (s[i] == '(') {
                    ++l;
                } else if (s[i] == ')') {
                    if (l > 0) {
                        --l;
                    } else {
                        return false;
                    }
                }
            }
        }
        int r = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (locked[i] == '0') {
                if (s[i] == ')') {
                    ++r;
                } else if (s[i] == '(') {
                    if (r > 0) {
                        --r;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
};