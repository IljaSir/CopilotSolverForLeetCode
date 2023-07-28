class Solution {
public:
    int maxNiceDivisors(int primeFactors) {
        
        if(primeFactors < 4) return primeFactors;
        int mod = 1000000007;
        int a = primeFactors / 3;
        int b = primeFactors % 3;
        if(b == 0) return pow(3, a, mod);
        if(b == 1) return pow(3, a-1, mod) * 4 % mod;
        return pow(3, a, mod) * 2 % mod;
    }
    
    long long pow(int a, int b, int mod) {
        if(b == 0) return 1;
        if(b % 2 == 0) {
            long long t = pow(a, b/2, mod);
            return t*t % mod;
        }
        return pow(a, b-1, mod) * a % mod;
    }
};