class Solution {
public:
    string greatestLetter(string s) {
        
        string res = "";
        int upper[26] = {0};
        int lower[26] = {0};
        for (char c : s) {
            if (isupper(c)) {
                upper[c - 'A'] = 1;
            } else {
                lower[c - 'a'] = 1;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (upper[i] == 1 && lower[i] == 1) {
                res += (i + 'A');
                return res;
            }
        }
        return res;
    }
};