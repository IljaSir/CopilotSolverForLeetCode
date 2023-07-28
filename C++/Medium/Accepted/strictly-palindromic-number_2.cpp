class Solution {
public:
    bool isStrictlyPalindromic(int n) {
        
        for (int i = 2; i < n; ++i) {
            int x = n;
            string s;
            while (x) {
                s += x % i + '0';
                x /= i;
            }
            if (s != string(s.rbegin(), s.rend())) {
                return false;
            }
        }
        return true;
    }
};