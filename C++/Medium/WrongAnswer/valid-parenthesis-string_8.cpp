class Solution {
public:
    bool checkValidString(string s) {
        
        int i = 0;
        int open = 0;
        int close = 0;
        int star = 0;
        int n = s.length();
        while(i < n) {
            if(s[i] == '(') {
                open++;
            } else if(s[i] == ')') {
                close++;
            } else {
                star++;
            }
            i++;
        }
        if(close > open + star) {
            return false;
        }
        i = 0;
        open = 0;
        close = 0;
        star = 0;
        while(i < n) {
            if(s[i] == '(') {
                open++;
            } else if(s[i] == ')') {
                close++;
            } else {
                star++;
            }
            if(close > open + star) {
                return false;
            }
            i++;
        }
        return true;
    }
};