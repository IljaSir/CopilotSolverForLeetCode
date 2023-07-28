class Solution {
public:
    int largestPalindrome(int n) {
        
        if (n == 1) {
            return 9;
        }
        int upper = pow(10, n) - 1;
        int lower = upper / 10;
        for (int i = upper; i > lower; i--) {
            long pal = build_palindrome(i);
            for (long j = upper; j * j >= pal; j--) {
                if (pal % j == 0) {
                    return pal % 1337;
                }
            }
        }
        return -1;
    }
};