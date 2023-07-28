class Solution {
public:
    char findTheDifference(string s, string t) {
        
        int c = 0;
        for (int i = 0; i < s.size(); i++) {
            c ^= s[i] ^ t[i];
        }
        c ^= t[t.size() - 1];
        return c;
    }
};