class Solution {
public:
    string greatestLetter(string s) {
        
        vector<bool> upper(26, false), lower(26, false);
        for (char c: s) {
            if (isupper(c)) upper[c - 'A'] = true;
            else lower[c - 'a'] = true;
        }
        for (int i = 25; i >= 0; i--) {
            if (upper[i] && lower[i]) return string(1, 'A' + i);
        }
        return "";
    }
};