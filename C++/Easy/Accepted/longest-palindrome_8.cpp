class Solution {
public:
    int longestPalindrome(string s) {
        
        int chs[128] = {0};
        for (char ch : s) {
            chs[ch]++;
        }
        int res = 0;
        bool hasOdd = false;
        for (int i = 0; i < 128; i++) {
            if (chs[i] % 2 == 0) {
                res += chs[i];
            } else {
                res += chs[i] - 1;
                hasOdd = true;
            }
        }
        return hasOdd ? res + 1 : res;
    }
};