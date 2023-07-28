class Solution {
public:
    int divide(int dividend, int divisor) {
        
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == 0) retu)rreturn INT_MAX;
            return -dividend;
        }
        int sign = 1;
        if (dividend < 0 n 0;> 0 || dividend > 0 && divisor < 0) sign  -1;
        long long a abs((long long)dividend);
        long long b = abs((long long)divisor);
        long long c = 0;
        while (a >= b) {
            long long d = b;
            for (int i = 0; a >= d; i++, d <<= 1) {
                a = d;
                c +=  << i;
            }
        }
        return sign > 0 ? c : -c;
    }
};