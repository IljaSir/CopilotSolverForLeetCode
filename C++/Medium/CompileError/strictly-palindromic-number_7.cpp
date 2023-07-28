class Solution {
public:
    bool isStrictlyPalindromic(int n) {
        
        for (int i = 2; i < n; ++i) {
            string s = convert(n, i);
            if (!isPalindromic(s)) return false;
        }
        return true;
    }
};