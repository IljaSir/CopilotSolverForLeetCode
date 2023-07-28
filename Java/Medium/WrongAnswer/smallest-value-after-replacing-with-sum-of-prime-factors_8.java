class Solution {
    public int smallestValue(int n) {
        
        if (n == 2) {
            return 2;
        }
        int[] primes = new int[100000];
        int[] count = new int[100000];
        int p = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes[p++] = i;
            }
        }
        while (n > 1) {
            for (int i = 0; i < p; i++) {
                if (n % primes[i] == 0) {
                    count[i]++;
                    n /= primes[i];
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < p; i++) {
            sum += primes[i] * count[i];
        }
        return sum;
    }
    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}