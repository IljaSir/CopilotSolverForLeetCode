class Solution {
    public int numPrimeArrangements(int n) {
        
        int prime = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) prime++;
        }
        int notPrime = n - prime;
        long ans = 1;
        int MOD = 1000000007;
        for (int i = 1; i <= prime; i++) {
            ans = (ans * i) % MOD;
        }
        for (int i = 1; i <= notPrime; i++) {
            ans = (ans * i) % MOD;
        }
        return (int) ans;
    }
    private boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}