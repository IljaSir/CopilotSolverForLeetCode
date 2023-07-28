class Solution {
    public int[] closestPrimes(int left, int right) {
        
        int[] result = new int[2];
        int[] primes = new int[right - left + 1];
        boolean[] isPrime = new boolean[right - left + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= right; i++) {
            for (int j = Math.max(2, (left + i - 1) / i) * i; j <= right; j += i) {
                isPrime[j - left] = false;
            }
        }
        int index = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime[i - left]) {
                primes[index++] = i;
            }
        }
        if (index < 2) {
            return new int[]{-1, -1};
        }
        int minGap = Integer.MAX_VALUE;
        for (int i = 1; i < index; i++) {
            if (primes[i] - primes[i - 1] < minGap) {
                minGap = primes[i] - primes[i - 1];
                result[0] = primes[i - 1];
                result[1] = primes[i];
            }
        }
        return result;
    }
}