class Solution {
public:
    int minNonZeroProduct(int p) {
        
        long long m = (1LL << p) - 1;
        long long n = (1LL << (p - 1)) - 1;
        return (m - 1) * powmod(n, m - 1, 1000000007) % 1000000007;
    }
    
    long long powmod(long long a, long long n, long long mod) {
        if (n == 0) return 1;
        if (n == 1) return a;
        if (n % 2 == 0) {
            long long x = powmod(a, n / 2, mod);
            return x * x % mod;
        } else {
            long long x = powmod(a, n - 1, mod);
            return x * a % mod;
        }
    }
};