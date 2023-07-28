class Solution {
public:
    int divide(int dividend, int divisor) {
        
        if (divisor == 0) {
            return INT_MAX;
        }
        if (dividend == 0) {
            return 0;
        }
        if (divisor == INT_MIN) {
            return dividend == INT_MIN ? 1 : 0;
        }
        if (dividend == INT_MIN) {
            if (divisor == -1) {
                return INT_MAX;
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
            quotient++;
        }
        return sign > 0 ? quotient : -quotient;
    }
};