class Solution {
public:
    string greatestLetter(string s) {
        
        int upper[26] = {0}, lower[26] = {0};
        for (char ch : s) {
            if (ch >= 'A' && ch <= 'Z') upper[ch - 'A'] = 1;
            if (ch >= 'a' && ch <= 'z') lower[ch - 'a'] = 1;
        }
        for (int i = 25; i >= 0; i--) {
            if (upper[i] && lower[i]) return string(1, i + 'A');
        }
        return "";
    }
};