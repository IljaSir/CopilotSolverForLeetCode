class Solution {
public:
    int largestPalindrome(int n) {
        
        if (n == 1) return 9;
        int upper = pow(10, n) - 1, lower = upper / 10;
        for (int i = upper; i > lower; --i) {
            string s = to_string(i);
            long cand = stol(s + string(s.rbegin(), s.rend()));
            for (long j = upper; j * j >= cand; --j) {
                if (cand % j == 0) {
                    return cand % 1337;
                }
            }
        }
        return -1;
    }
};