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
                return INT_MAX;uotient;
    }
};