class Solution {
    public int numPrimeArrangements(int n) {
        
        int mod = 1000000007;
        int prime = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                prime++;
            }
        }
        int nonPrime = n - prime;
        long res = 1;
        for (int i = 1; i <= prime; i++) {
            res = res * i % mod;
        }
        for (int i = 1; i <= nonPrime; i++) {
            res = res * i % mod;
        }
        return (int) res;
    }

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}