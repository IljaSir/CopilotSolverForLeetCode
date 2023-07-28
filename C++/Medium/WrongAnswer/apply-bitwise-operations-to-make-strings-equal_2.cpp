class Solution {
public:
    bool makeStringsEqual(string s, string target) {
        
        int x = 0;
        for (int i = 0; i < s.size(); ++i) {
            x ^= s[i] - '0';
            x ^= target[i] - '0';
        }
        return x == 0;
    }
};