class Solution {
public:
    string longestPalindrome(string s) {
        
        int n = s.size();
        if (n == 0) return "";
        int start = 0;
        int maxlen = 1;
        for (int i = 0; i < n; ) {
            if (n - i <= maxlen / 2) break;
            int j = i, k = i;
            while (k < n - 1 && s[k] == s[k + 1]) ++k; // Skip duplicate characters.
            i = k + 1;
            while (k < n - 1 && j > 0 && s[k + 1] == s[j - 1]) {++k; --j;} // Expand.
            int newlen = k - j + 1;
            if (newlen > maxlen) {start = j; maxlen = newlen;}
        }
        return s.substr(start, maxlen);
    }
};