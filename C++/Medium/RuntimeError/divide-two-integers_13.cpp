class Solution {
public:
    int divide(int dividend, int divisor) {
        
        if (dividend == INT_MIN && divisor == -1) return INT_MAX;
        int sign = 1;
        if (divisor < 0) {
            sign *= -1;
            divisor = -divisor;
        }
        if (dividend < 0) {
            sign *= -1;
            dividend = -dividend;
        }
        int res = 0;
        while (dividend >= divisor) {
            int temp = divisor, multiple = 1;
            while (dividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dividend -= temp;
            res += multiple;
        }
        return sign == 1 ? res : -res;
    }
};