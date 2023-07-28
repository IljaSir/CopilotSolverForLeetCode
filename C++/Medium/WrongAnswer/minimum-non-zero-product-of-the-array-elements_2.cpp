class Solution {
public:
    int minNonZeroProduct(int p) {
        
        long long res = (1LL << p) - 1;
        long long mod = 1e9 + 7;
        long long a = (1LL << (p - 1)) - 1;
        long long b = (1LL << (p - 1));
        long long c = (a * b) % mod;
        return (res * pow(c, res - 1, mod)) % mod;
    }
    long long pow(long long a, long long b, long long mod) {
        long long res = 1;
        while (b) {
            if (b & 1) res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
};