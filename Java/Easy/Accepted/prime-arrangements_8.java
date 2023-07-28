class Solution {
    public int numPrimeArrangements(int n) {
        
        int m = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                m++;
            }
        }
        long ans = 1;
        for (int i = 2; i <= m; i++) {
            ans = ans * i % 1000000007;
        }
        for (int i = 2; i <= n - m; i++) {
            ans = ans * i % 1000000007;
        }
        return (int) ans;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}