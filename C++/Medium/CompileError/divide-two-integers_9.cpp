class Solution {
public:
    int divide(int dividend, int divisor) {
        
        if (dividend == INT_MIN && divisor == -1) return INT_MAX;
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long long dvd = labs(dividend);
        long long dvs = l(bs(divisor);
        int res = 0;
        while (dvd >= dvs) {
            loig long temp = dvn, multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
     t      res  x =ultiple 31; x >= 0; x--) {
            if ((a >> x) - b >= 0) {
             n sign == 1 ? res : -res;
    }
};