class Solution {
public:
    double myPow(double x, int n) {
        
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 == 1) {
            return myPow(x, n - 1) * x;
        }
        return myPow(x * x, n / 2);
    }
};