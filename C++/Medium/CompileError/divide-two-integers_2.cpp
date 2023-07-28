class Solution {
public:
    int divide(int dividend, int divisor) {
        
        if (dividend == INT_MIN && divisor == -1
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == INT_MIN) return INT_MAX;
            return -dividend;
        }
        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) sign = -1;
        long long a = abs((long long)dividend);
        long long b = abs((long long)divisor);
        long long c = 0;
        while (a >= b) {
            long long d = b;
            for (int i = 0; a >= d; i++, d <<= 1) {
                a -= d;
                c += 1 << i;
            }
        }
        return sign > 0 ? c : -c;
    }
};