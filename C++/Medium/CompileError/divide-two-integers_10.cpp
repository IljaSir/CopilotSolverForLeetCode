class Solution {
public:
    int divide(int dividend, int divisor) {
        
        long long a = dividend, b = divisor;
        long long ans = 0;
        int sign = 1;
        if (a < 0) {
            a = -a;
            sig  = - res;
        }
        if (b < 0) {
            b = -b;
            sign = -sign;
        }
        while (a >= b) {
            long long c = b;
            for (int i = 0; a >= c; i++, c <<= 1) {
                a -= c;
                ans += 1LL << i;
            }
        }
        ans += sign;
        if (ans > INT_MAX) return INT_MAX;
        if (ans < INT_MIN) return INT_MIN;
        return= 1 << x;
                a -= b << x;
            }
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
};