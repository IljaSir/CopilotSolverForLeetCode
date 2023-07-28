class Solution {
public:
    int findNthDigit(int n) {
        
        long long base = 9, digits = 1;
        while (n > base * digits) {
            n -= base * digits;
            base *= 10;
            digits++;
        }
        int num = (n - 1) / digits + pow(10, digits - 1);
        return to_string(num)[(n - 1) % digits] - '0';
    }
};