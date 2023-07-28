class Solution {
public:
    int divide(int dividend, int divisor) {
        
        if ( long a = dividend, b = divisor;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = abs(a);
        b = abs(b);
        long long res = 0;
        while (a >= b) {
            long long c = b;
            for (int i = 0; a >= c; ++i, c <<= 1) {
                a -= c;
                res += 1LL << i;
            }
        }
        res *= sign;
        if (res > INT_MAX || res < INT_MIN) return INT_MAX;
        return res;
    }
};