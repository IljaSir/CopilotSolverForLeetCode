class Solution {
    public int smallestValue(int n) {
        
        int[] primes = new int[100000];
        int[] primeCount = new int[100000];
        int primeCountCount = 0;
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 0) {
                primes[primeCountCount++] = i;
            }
            for (int j = 0; j < primeCountCount && primes[j] * i < n; j++) {
                primes[primes[j] * i] = 1;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < primeCountCount; i++) {
            int prime = primes[i];
            while (n % prime == 0) {
                result += prime;
                n /= prime;
            }
        }
        return result;
    }
}