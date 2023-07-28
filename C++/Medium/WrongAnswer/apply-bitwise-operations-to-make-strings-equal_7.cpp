class Solution {
public:
    bool makeStringsEqual(string s, string target) {
        
        int c1 = 0, c2 = 0;
        for (char c : s) {
            if (c == '1') {
                c1++;
            }
        }
        for (char c : target) {
            if (c == '1') {
                c2++;
            }
        }
        return c1 == c2;
    }
};