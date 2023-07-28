class Solution {
public:
    bool isValid(string s) {
        
        int n = s.length();
        if (n % 3 != 0) return false;
        if (n == 0) return true;
        string t = "";
        for (int i = 0; i < n; i++) {
            t += s[i];
            int m = t.length();
            if (m >= 3 && t.substr(m - 3, 3) == "abc") {
                t = t.substr(0, m - 3);
            }
        }
        return t.length() == 0;
    }
};