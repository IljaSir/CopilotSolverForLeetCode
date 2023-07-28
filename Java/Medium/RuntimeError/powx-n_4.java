class Solution {
    public double myPow(double x, int n) {
        
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 == 0) {
            double y = myPow(x, n / 2);
            return y * y;
        } else {
            return x * myPow(x, n - 1);
        }
    }
}