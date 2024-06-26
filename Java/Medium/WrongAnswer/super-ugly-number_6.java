class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * ugly[index[j]]);
            }
            ugly[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * ugly[index[j]] == min) {
                    index[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
}