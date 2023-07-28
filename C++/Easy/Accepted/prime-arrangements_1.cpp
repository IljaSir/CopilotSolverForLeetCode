class Solution {
public:
    int numPrimeArrangements(int n) {
        
        vector<int> primes;
        for (int i = 2; i <= n; ++i) {
            bool isPrime = true;
            for (int j = 2; j < i; ++j) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes.push_back(i);
        }
        int primeCount = primes.size();
        int nonPrimeCount = n - primeCount;
        long long int result = 1;
        for (int i = 2; i <= primeCount; ++i) {
            result = (result * i) % 1000000007;
        }
        for (int i = 2; i <= nonPrimeCount; ++i) {
            result = (result * i) % 1000000007;
        }
        return result;
    }
};