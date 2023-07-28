class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] idx = new int[primes.length];
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ugly[i] = Math.min(ugly[i], ugly[idx[j]] * primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (ugly[i] == ugly[idx[j]] * primes[j]) {
                    idx[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
}