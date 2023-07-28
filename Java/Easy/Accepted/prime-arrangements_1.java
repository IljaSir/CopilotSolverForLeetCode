class Solution {
    public int numPrimeArrangements(int n) {
        
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
        int nonPrimeCount = n - primeCount;
        long result = 1;
        // Calculate factorial of primeCount
        for (int i = 2; i <= primeCount; i++) {
            result = (result * i) % 1000000007;
        }
        // Calculate factorial of nonPrimeCount
        for (int i = 2; i <= nonPrimeCount; i++) {
            result = (result * i) % 1000000007;
        }
        return (int) result;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}