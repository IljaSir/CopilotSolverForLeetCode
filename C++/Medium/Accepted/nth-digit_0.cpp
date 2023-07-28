class Solution {
public:
    int findNthDigit(int n) {
        
        long long base = 9, digits = 1;
        while (n - base * digits > 0) {
            n -= base * digits;
            base *= 10;
            digits++;
        }
        long long num = 1;
        for (int i = 1; i < digits; i++) num *= 10;
        num += (n - 1) / digits;
        string s = to_string(num);
        return s[(n - 1) % digits] - '0';
    }
};