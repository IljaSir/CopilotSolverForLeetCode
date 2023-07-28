class Solution {
public:
    string longestPalindrome(string s) {
        
        int n = s.length();
        string ans = "";
        int start = 0, len = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s[l] == s[r]) {
                l--;
                r++;
            }
            if (r - l - 1 > len) {
                start = l + 1;
                len = r - l - 1;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s[l] == s[r]) {
                l--;
                r++;
            }
            if (r - l - 1 > len) {
                start = l + 1;
                len = r - l - 1;
            }
        }
        return s.substr(start, len);
    }
};