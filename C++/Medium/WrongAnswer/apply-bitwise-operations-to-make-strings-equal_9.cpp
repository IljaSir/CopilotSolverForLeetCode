class Solution {
public:
    bool makeStringsEqual(string s, string target) {
        
        int c1 = 0, c0 = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == '1') ++c1;
            if (target[i] == '1') ++c1;
            if (s[i] == '0') ++c0;
            if (target[i] == '0') ++c0;
        }
        return c1 % 2 == 0 && c0 % 2 == 0;
    }
};