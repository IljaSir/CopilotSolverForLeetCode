class Solution {
    public int numPrimeArrangements(int n) {
        
        int primeCount = 0;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeCount++;
                for (int j = 2 * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        long result = 1;
        for (int i = 1; i <= primeCount; i++) {
            result = (result * i) % 1000000007;
        }
        for (int i = 1; i <= n - primeCount; i++) {
            result = (result * i) % 1000000007;
        }
        return (int) result;
    }
}