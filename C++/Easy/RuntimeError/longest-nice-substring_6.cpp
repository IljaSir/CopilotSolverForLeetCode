class Solution {
public:
    string longestNiceSubstring(string s) {
        
        int n = s.size();
        for (int i = 0; i < n; i++) {
            if (islower(s[i]) && islower(s[i + 1])) {
                continue;
            }
            if (isupper(s[i]) && isupper(s[i + 1])) {
                continue;
            }
            string left = longestNiceSubstring(s.substr(0, i + 1));
            string right = longestNiceSubstring(s.substr(i + 1));
            return left.size() >= right.size() ? left : right;
        }
        return s;
    }
};