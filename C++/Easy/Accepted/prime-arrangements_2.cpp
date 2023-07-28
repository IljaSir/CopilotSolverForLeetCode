class Solution {
public:
    int numPrimeArrangements(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        int mod = 1e9 + 7;
        long long res = 1;
        for (int i = 1; i <= count; i++) {
            res = (res * i) % mod;
        }
        for (int i = 1; i <= n - count; i++) {
            res = (res * i) % mod;
        }
        return res;
    }
    
    bool isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
};