class Solution {
public:
    int maxNiceDivisors(int primeFactors) {
        
        if (primeFactors < 4) return primeFactors;
        int mod = 1e9 + 7;
        long long res = 1;
        while (primeFactors > 4) {
            res *= 3;
            res %= mod;
            primeFactors -= 3;
        }
        return (res * primeFactors) % mod;
    }
};