class Solution {
public:
    string freqAlphabets(string s) {
        
        string result = "";
        for (int i = 0; i < s.size(); i++) {
            if (i + 2 < s.size() && s[i + 2] == '#') {
                result += 'j' + (s[i] - '0') * 10 + s[i + 1] - '1';
                i += 2;
            } else {
                result += 'a' + s[i] - '1';
            }
        }
        return result;
    }
};