class Solution {
public:
    string greatestLetter(string s) {
        
        int n = s.size();
        if (n == 0) return "";
        if (n == 1) return s;
        sort(s.begin(), s.end());
        for (int i = 1; i < n; i++) {
            if (s[i] == s[i - 1] + 32) return string(1, s[i]);
        }
        return "";
    }
};