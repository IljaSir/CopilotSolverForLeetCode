class Solution {
public:
    int largestPalindrome(int n) {
        
        if (n == 1) return 9;
        int upper = pow(10, n) - 1;
        int lower = upper / 10;
        for (int i = upper; i > lower; --i) {
            string s = to_string(i);
            long candidate = stol(s + string(s.rbegin(), s.rend()));
            for (long j = upper; j * j >= candidate; --j) {
                if (candidate % j == 0) {
                    return candidate % 1337;
                }
            }
        }
        return -1;
    }
};