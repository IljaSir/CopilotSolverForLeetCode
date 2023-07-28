class Solution {
public:
    int findNthDigit(int n) {
        
        long long i = 1, base = 10, offset = 0;
        while (n > i * 9 * base) {
            n -= i * 9 * base;
            i++;
            base *= 10;
            offset += 9 * base / 10;
        }
        return to_string(offset + n / i)[n % i] - '0';
    }
};