class Solution {
    public int minNonZeroProduct(int p) {
        
        long n = (1 << p) - 1;
        long n2 = (1 << (p - 1)) - 1;
        return (int)((n - 1) % 1000000007 * pow(n - 2, n2 - 1) % 1000000007);
    }
    
    private long pow(long x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x % 1000000007;
        if (n % 2 == 0) {
            long y = pow(x, n / 2);
            return y * y % 1000000007;
        } else {
            return x * pow(x, n - 1) % 1000000007;
        }
    }
}