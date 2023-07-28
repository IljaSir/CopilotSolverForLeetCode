class Solution {
    public int maxNiceDivisors(int primeFactors) {
        
        if (primeFactors < 4) {
            return primeFactors;
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