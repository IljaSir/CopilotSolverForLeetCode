class Solution {
public:
    string freqAlphabets(string s) {
        
        string res;
        for (int i = s.size() - 1; i >= 0; --i) {
            if (s[i] == '#') {
                res += (char)('a' + (s[i - 1] - '0') + (s[i - 2] - '0') * 10 - 1);
                i -= 2;
            } else {
                res += (char)('a' + s[i] - '0' - 1);
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};