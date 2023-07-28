class Solution {
    public int maxNiceDivisors(int primeFactors) {
        
        if (primeFactors <= 3) {
            return primeFactors;
        }
        int mod = 1000000007;
        long a = primeFactors / 3;
        long b = primeFactors % 3;
        long result = 1;
        for (int i = 0; i < a - 1; i++) {
            result = result * 3 % mod;
        }
        if (b == 0) {
            result = result * 3 % mod;
        } else if (b == 1) {
            result = result * 4 % mod;
        } else {
            result = result * 6 % mod;
        }
        return (int)result;
    }
}