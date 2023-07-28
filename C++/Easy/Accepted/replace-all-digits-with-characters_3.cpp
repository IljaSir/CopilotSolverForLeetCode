class Solution {
public:
    string replaceDigits(string s) {
        
        char c;
        for(int i = 1; i < s.length(); i += 2) {
            c = s[i-1] + s[i] - '0';
            s[i] = c;
        }
        return s;
    }
};