class Solution {
    public int minNonZeroProduct(int p) {
        
        long mod = 1000000007;
        long ans = power(2, p) - 1;
        long n = power(2, p - 1) - 1;
        ans = ans * power(n, n / 2) % mod;
        return (int)ans;
    }
    public long power(long a, long b) {
        long mod = 1000000007;
        long ans = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
            b /= 2;
        }
        return ans;
    }
}