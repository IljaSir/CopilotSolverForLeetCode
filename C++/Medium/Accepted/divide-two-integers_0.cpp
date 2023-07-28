class Solution {
public:
    int divide(int dividend, int divisor) {
        
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend > INT_MIN) return -dividend;
            return INT_MAX;
        }
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
        long long a = dividend;
        long long b = divisor;
        a = abs(a);
        b = abs(b);
        long long ans = 0;
        while (a >= b) {
            long long c = b;
            for (int i = 0; a >= c; ++i, c <<= 1) {
                a -= c;
                ans += 1 << i;
            }
        }
        return sign * ans;
    }
};