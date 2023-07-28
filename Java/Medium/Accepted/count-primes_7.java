class Solution {
    public int countPrimes(int n) {
        
        if (n < 3) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = i + i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        return count;
    }
}