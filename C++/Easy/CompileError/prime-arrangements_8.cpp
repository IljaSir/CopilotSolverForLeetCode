class Solution {
public:
    int numPrimeArrangements(int n) {
        
        int prime = 0;
        for (int i = 1; i <= n; ++i) {
            if (isPrime(i)) ++prime;
        }
        int nonPrime = n - prime;
        long long ans = 1;
        for (int i = 1; i <= prime; ++i) {
            ans = (ans * i) % 1000000007;
        }
        for (int i = 1; i <= nonPrime; ++i) {
            ans = (ans * i) % 1000000007;
        }
        return ans;
    }
};