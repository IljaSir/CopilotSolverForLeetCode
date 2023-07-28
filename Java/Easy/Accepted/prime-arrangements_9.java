class Solution {
    public int numPrimeArrangements(int n) {
        
        if (n < 2) return 1;
        int prime = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) prime++;
        }
        int notPrime = n - prime;
        long ans = 1;
        for (int i = 1; i <= prime; i++) {
            ans = ans * i % 1000000007;
        }
        for (int i = 1; i <= notPrime; i++) {
            ans = ans * i % 1000000007;
        }
        return (int) ans;
    }
    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}