class Solution {
    public int maxNiceDivisors(int primeFactors) {
        
        if (primeFactors < 4) {
            return primeFactors;
        }
        int mod = 1000000007;
        long result = 1;
        while (primeFactors > 4) {
            result = (result * 3) % mod;
            primeFactors -= 3;
        }
        return (int) ((result * primeFactors) % mod);
    }
}