class Solution {
    public int[] closestPrimes(int left, int right) {
        
        int[] res = new int[2];
        int[] primes = new int[right - left + 1];
        int[] primes2 = new int[right - left + 1];
        int index = 0, index2 = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                primes[index++] = i;
            }
            if (isPrime2(i)) {
                primes2[index2++] = i;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index2; j++) {
                if (primes[i] == primes2[j]) {
                    if (primes[i] - primes2[j] < min) {
                        min = primes[i] - primes2[j];
                        res[0] = primes[i];
                        res[1] = primes2[j];
                    }
                }
            }
        }
        if (res[0] == 0) {
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    public boolean isPrime2(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}