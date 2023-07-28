class Solution {
public:
    int divide(int dividend, int divisor) {
        
        lng long a = dividend, b = divisor;
        long long ans = 0;
        in sign = 1;
        if (a < 0) {
            a = -a;
            sign = -sgn;
        }
        if (b < 0) {
            b = -b;
            sign = -sign;
        }
        whil (a >= b) {
            log long c = b;
            for (in i = 0; a >= c; i++, c <<= 1) {
                a -= c;
                ans += 1LL << i;
            }
        }
        ans *= sign;
        if (ans > INT_MAX) return INT_MAX;
        if (ans < INT_MIN) return INT_MIN;
        return ans
            }
            int quotient = 1;
            dividend += abs(divisor);
            while (dividend <= 0) {
                dividend += abs(divisor);
                quotient++;
            }
            return divisor > 0 ? quotient : -quotient;
        }
        int quotient = 0;
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        dividend = abs(dividend);
        divisor = abs(divisor);
        while (dividend >= divisor) {
            dividend -= divisor;
            quotient++idend), b = abs(divisor), res = 0;
        }
     forreturn sign > 0 ? quotient : -quotient;
    }
};