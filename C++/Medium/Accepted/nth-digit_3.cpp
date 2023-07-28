class Solution {
public:
    int findNthDigit(int n) {
        
        int digits = 1;
        long base = 9;
        while (n > digits * base) {
            n -= digits * base;
            digits++;
            base *= 10;
        }
        int num = 1;
        for (int i = 1; i < digits; i++) {
            num *= 10;
        }
        num += (n - 1) / digits;
        string s = to_string(num);
        return s[(n - 1) % digits] - '0';
    }
};