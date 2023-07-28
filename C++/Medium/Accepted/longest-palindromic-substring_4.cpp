class Solution {
public:
    string longestPalindrome(string s) {
        
        int n = s.length();
        if (n <= 1) return s;
        int maxLen = 1, start = 0;
        for (int i = 0; i < n;) {
            if (n - i <= maxLen / 2) break;
            int left = i, right = i;
            while (right < n - 1 && s[right] == s[right + 1]) right++;
            i = right + 1;
            while (right < n - 1 && left > 0 && s[right + 1] == s[left - 1]) {
                right++;
                left--;
            }
            int newLen = right - left + 1;
            if (newLen > maxLen) {
                maxLen = newLen;
                start = left;
            }
        }
        return s.substr(start, maxLen);
    }
};