class Solution {
    public int[] closestPrimes(int left, int right) {
        
        int[] result = new int[2];
        int current = left;
        int minDiff = Integer.MAX_VALUE;
        while (current <= right) {
            int[] primes = getPrimes(current);
            int diff = primes[1] - primes[0];
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes[0];
                result[1] = primes[1];
            }
            current++;
        }
        return result;
    }

    private int[] getPrimes(int num) {
        int[] result = new int[2];
        result[0] = getPreviousPrime(num);
        result[1] = getNextPrime(num);
        return result;
    }

    private int getPreviousPrime(int num) {
        if (num <= 2) {
            return -1;
        }
        int i = num - 1;
        while (i > 1) {
            if (isPrime(i)) {
                return i;
            }
            i--;
        }
        return -1;
    }

    private int getNextPrime(int num) {
        if (num <= 2) {
            return 2;
        }
        int i = num + 1;
        while (i < Integer.MAX_VALUE) {
            if (isPrime(i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}