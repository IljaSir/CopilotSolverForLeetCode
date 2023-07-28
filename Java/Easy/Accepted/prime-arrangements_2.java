class Solution {
    public int numPrimeArrangements(int n) {
        
        int mod = 1000000007;
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
        int nonPrimeCount = n - primeCount;
        long result = 1;
        for (int i = 1; i <= primeCount; i++) {
            result = (result * i) % mod;
        }
        for (int i = 1; i <= nonPrimeCount; i++) {
            result = (result * i) % mod;
        }
        return (int) result;
    }
    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}