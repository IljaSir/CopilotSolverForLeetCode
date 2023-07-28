class Solution {
public:
    bool isStrictlyPalindromic(int n) {
        
        for (int b = 2; b < n - 1; ++b) {
            int m = n;
            string s;
            while (m > 0) {
                s.push_back(m % b + '0');
                m /= b;
            }
            string t = s;
            reverse(t.begin(), t.end());
            if (s != t) {
                return false;
            }
        }
        return true;
    }
};