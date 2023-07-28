class Solution {
public:
    string freqAlphabets(string s) {
        
        int n = s.size();
        if (n == 0) return "";
        string res = "";
        for (int i = 0; i < n; i++) {
            if (i + 2 < n && s[i + 2] == '#') {
                res += 'j' + (s[i] - '0') * 10 + s[i + 1] - '1';
                i += 2;
            } else {
                res += 'a' + s[i] - '1';
            }
        }
        return res;
    }
};