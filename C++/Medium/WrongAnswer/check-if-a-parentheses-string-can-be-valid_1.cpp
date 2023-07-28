class Solution {
public:
    bool canBeValid(string s, string locked) {
        
        int n = s.length();
        int open = 0;
        for (int i = 0; i < n; i++) {
            if (locked[i] == '0') {
                if (s[i] == '(') {
                    open++;
                } else if (open > 0) {
                    open--;
                } else {
                    s[i] = '(';
                    open++;
                }
            } else if (s[i] == '(') {
                open++;
            } else {
                open--;
            }
        }
        int close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked[i] == '0') {
                if (s[i] == ')') {
                    close++;
                } else if (close > 0) {
                    close--;
                } else {
                    s[i] = ')';
                    close++;
                }
            } else if (s[i] == ')') {
                close++;
            } else {
                close--;
            }
        }
        return open == 0 && close == 0;
    }
};