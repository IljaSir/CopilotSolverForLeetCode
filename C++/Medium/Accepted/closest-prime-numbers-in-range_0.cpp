class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        
        vector<int> primes;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                primes.push_back(i);
            }
        }
        if (primes.size() < 2) {
            return {-1, -1};
        }
        int minDiff = primes[1] - primes[0];
        int minIndex = 0;
        for (int i = 2; i < primes.size(); i++) {
            if (primes[i] - primes[i - 1] < minDiff) {
                minDiff = primes[i] - primes[i - 1];
                minIndex = i - 1;
            }
        }
        return {primes[minIndex], primes[minIndex + 1]};
    }
    
    bool isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
};