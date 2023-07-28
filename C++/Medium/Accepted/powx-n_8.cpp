class Solution {
public:
    double myPow(double x, int n) {
        
        double ans = 1;
        long nn = n;
        if (n < 0) {
            nn = -nn;
            x = 1 / x;
        }
        while (nn) {
            if (nn & 1) ans *= x;
            x *= x;
            nn >>= 1;
        }
        return ans;
    }
};