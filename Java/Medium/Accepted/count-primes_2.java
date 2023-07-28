class Solution {
    public int countPrimes(int n) {
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
                for (int j = i + i; j < n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
        return count;
    }
}