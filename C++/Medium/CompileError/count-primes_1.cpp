class Solution {
public:
    int countPrimes(int n) {
        
        int or<bool> isPrime(n, true);
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i]) {
                ++count;
                if ((long long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return count;
    }
};