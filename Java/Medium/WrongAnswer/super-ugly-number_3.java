class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] idx = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, ugly[idx[j]] * primes[j]);
            }
            ugly[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (ugly[i] == ugly[idx[j]] * primes[j]) {
                    idx[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
}