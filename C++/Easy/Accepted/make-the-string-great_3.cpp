class Solution {
public:
    string makeGood(string s) {
        
        int len = s.length();
        int i = 0;
        while (i < len - 1) {
            if (abs(s[i] - s[i + 1]) == 32) {
                s.erase(i, 2);
                i = 0;
                len -= 2;
            } else {
                i++;
            }
        }
        return s;
    }
};