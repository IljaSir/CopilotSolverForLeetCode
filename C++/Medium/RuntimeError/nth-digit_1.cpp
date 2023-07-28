class Solution {
public:
    int findNthDigit(int n) {
        
        int base = 9;
        int digits = 1;
        while (n > base * digits) {
            n -= base * digits;
            base *= 10;
            digits++;
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