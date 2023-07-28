class Solution {
    public int minNonZeroProduct(int p) {
        
        long mod = 1000000007;
        long n = (1L << p) - 1;
        long a = (n-1) / 2;
        long b = n - 1;
        long res = pow(a, b, mod);
        return (int) ((res * n) % mod);
    }
}