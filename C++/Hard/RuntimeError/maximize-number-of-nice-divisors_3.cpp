class Solution {
public:
    int maxNiceDivisors(int primeFactors) {
        
        if (primeFactors == 1) return 1;
        if (primeFactors == 2) return 2;
        if (primeFactors == 3) return 3;
        int mod = 1e9 + 7;
        int a = primeFactors / 3, b = primeFactors % 3;
        if (b == 0) return qpow(3, a, mod);
        if (b == 1) return qpow(3, a - 1, mod) * 4 % mod;
        return qpow(3, a, mod) * 2 % mod;
    }
    int qpow(int a, int b, int mod) {
        int res = 1;
        while (b) {
            if (b & 1) res = (long long)res * a % mod;
            a = (long long)a * a % mod;
            b >>= 1;
        }
        return res;
    }
};