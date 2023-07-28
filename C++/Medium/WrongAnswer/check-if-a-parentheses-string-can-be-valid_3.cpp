class Solution {
public:
    bool canBeValid(string s, string locked) {
        
        int n = s.size();
        int open = 0, close = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                open++;
            } else {
                close++;
            }
            if (open < close) {
                if (locked[i] == '1') {
                    return false;
                }
                s[i] = '(';
                open++;
                close--;
            }
        }
        open = 0, close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == '(') {
                open++;
            } else {
                close++;
            }
            if (open > close) {
                if (locked[i] == '1') {
                    return false;
                }
                s[i] = ')';
                open--;
                close++;
            }
        }
        return true;
    }
};