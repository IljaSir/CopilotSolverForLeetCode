class Solution {
public:
    int numPrimeArrangements(int n) {
        
        int p = 0, mod = 1e9 + 7;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                p++;
            }
        }
        long long res = 1;
        for (int i = 1; i <= p; i++) {
            res = (res * i) % mod;
        }
        for (int i = 1; i <= n - p; i++) {
            res = (res * i) % mod;
        }
        return res;
    }
};