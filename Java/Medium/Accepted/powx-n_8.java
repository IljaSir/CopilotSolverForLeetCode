class Solution {
    public double myPow(double x, int n) {
        
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / (x * myPow(x, -(n + 1)));
        }
        if (n % 2 == 0) {
            double half = myPow(x, n / 2);
            return half * half;
        }
        return x * myPow(x, n - 1);
    }
}