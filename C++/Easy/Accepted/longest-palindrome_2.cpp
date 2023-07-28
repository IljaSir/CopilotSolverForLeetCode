class Solution {
public:
    int longestPalindrome(string s) {
        
        int n = s.length();
        int count[256] = {0};
        for (int i = 0; i < n; i++) {
            count[s[i]]++;
        }
        int res = 0;
        bool odd = false;
        for (int i = 0; i < 256; i++) {
            if (count[i] % 2 == 0) {
                res += count[i];
            } else {
                res += count[i] - 1;
                odd = true;
            }
        }
        return res + odd;
    }
};