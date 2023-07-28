class Solution {
public:
    bool makeStringsEqual(string s, string target) {
        
        int c1 = 0, c2 = 0;
        for (int i = 0; i < s.size(); i++) {
            c1 += s[i] - '0';
            c2 += target[i] - '0';
        }
        return c1 % 2 == c2 % 2;
    }
};