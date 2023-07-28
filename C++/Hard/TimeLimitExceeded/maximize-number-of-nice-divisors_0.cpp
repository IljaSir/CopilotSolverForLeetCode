class Solution {
public:
    int maxNiceDivisors(int primeFactors) {
        
        if (primeFactors == 1) {
            return 1;
        }
        if (primeFactors == 2) {
            return 2;
        }
        if (primeFactors == 3) {
            return 3;
        }
        long long mod = 1000000007;
        long long ans = 1;
        while (primeFactors > 4) {
            ans = (ans * 3) % mod;
            primeFactors -= 3;
        }
        ans = (ans * primeFactors) % mod;
        return ans;
    }
};