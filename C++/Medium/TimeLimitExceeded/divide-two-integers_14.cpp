class Solution {
public:
    int divide(int dividend, int divisor) {
        
        if (dividend == INT_MIN && divisor == -1)
            return INT_MAX;
        unsigned int udividend = abs(dividend);
        unsigned int udivisor = abs(divisor);
        unsigned int res = 0;
        while (udividend >= udivisor) {
            unsigned int tmp = udivisor;
            unsigned int mul = 1;
            while (udividend >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }
            res += mul;
            udividend -= tmp;
        }
        return ((dividend < 0) ^ (divisor < 0)) ? -res : res;
    }
};