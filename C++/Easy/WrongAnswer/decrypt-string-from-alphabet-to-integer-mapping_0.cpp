class Solution {
public:
    string freqAlphabets(string s) {
        
        string res;
        for (int i = 0; i < s.size(); ++i) {
            if (i + 2 < s.size() && s[i + 2] == '#') {
                res.push_back('j' + (s[i] - '0') * 10 + s[i + 1] - '1');
                i += 2;
            } else {
                res.push_back('a' + s[i] - '1');
            }
        }
        return res;
    }
};