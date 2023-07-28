class Solution {
public:
    int mySqrt(int x) {
        
        if (x == 0)
            return 0;
        double x0 = x;
        double x1 = (x0 + x / x0) / 2;
        while (abs(x1 - x0) > 0.00001) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2;
        }
        return int(x1);
    }
};