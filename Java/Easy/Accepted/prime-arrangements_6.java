class Solution {
    public int numPrimeArrangements(int n) {
        
        int[] primes = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            if (primes[i] == 0) {
                for (int j = i + i; j < n + 1; j += i) {
                    primes[j] = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i < n + 1; i++) {
            if (primes[i] == 0) {
                cnt++;
            }
        }
        int mod = 1000000007;
        long ans = 1;
        for (int i = 1; i <= cnt; i++) {
            ans = (ans * i) % mod;
        }
        for (int i = 1; i <= n - cnt; i++) {
            ans = (ans * i) % mod;
        }
        return (int) ans;
    }
}