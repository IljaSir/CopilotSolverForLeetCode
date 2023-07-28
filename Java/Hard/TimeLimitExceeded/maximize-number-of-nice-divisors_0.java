class Solution {
    public int maxNiceDivisors(int primeFactors) {
        
        if (primeFactors == 1) {
            return 1;
        }
        if (primeFactors == 2) {
            return 2;
        }
        if (primeFactors == 3) {
            return 3;
        }
        int mod = 1000000007;
        long res = 1;
        while (primeFactors > 4) {
            res = res * 3 % mod;
            primeFactors -= 3;
        }
        return (int) (res * primeFactors % mod);
    }
}