class Solution {
    public int maxNiceDivisors(int primeFactors) {
        
        if (primeFactors <= 3) {
            return primeFactors;
        }
        int mod = 1000000007;
        long res = 1;
        if (primeFactors % 3 == 1) {
            res *= 4;
            primeFactors -= 4;
        } else if (primeFactors % 3 == 2) {
            res *= 2;
            primeFactors -= 2;
        }
        while (primeFactors > 0) {
            res = (res * 3) % mod;
            primeFactors -= 3;
        }
        return (int)res;
    }
}