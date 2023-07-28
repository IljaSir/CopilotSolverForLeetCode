class Solution {
public:
    int numPrimeArrangements(int n) {
        
        int prime = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) prime++;
        }
        int nonPrime = n - prime;
        long long res = 1;
        for (int i = 1; i <= prime; i++) {
            res = (res * i) % 1000000007;
        }
        for (int i = 1; i <= nonPrime; i++) {
            res = (res * i) % 1000000007;
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