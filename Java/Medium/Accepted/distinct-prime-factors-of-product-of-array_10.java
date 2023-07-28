class Solution {
    public int distinctPrimeFactors(int[] nums) {
        
        int max = 1000;
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= max; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j <= max; j += i) {
                isPrime[j] = false;
            }
        }
        int[] primes = new int[max + 1];
        int[] counts = new int[max + 1];
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes[i] = i;
            } else {
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        primes[i] = j;
                        break;
                    }
                }
            }
        }
        for (int num : nums) {
            while (num > 1) {
                int prime = primes[num];
                while (num % prime == 0) {
                    num /= prime;
                }
                counts[prime]++;
            }
        }
        int res = 0;
        for (int count : counts) {
            if (count > 0) {
                res++;
            }
        }
        return res;
    }
}