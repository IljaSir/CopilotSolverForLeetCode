class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        
        vector<int> ugly(n);
        vector<int> ptr(primes.size(), 0);
        ugly[0] = 1;
        for (int i = 1; i < n; ++i) {
            ugly[i] = INT_MAX;
            for (int j = 0; j < primes.size(); ++j) {
                ugly[i] = min(ugly[i], ugly[ptr[j]] * primes[j]);
            }
            for (int j = 0; j < primes.size(); ++j) {
                if (ugly[i] == ugly[ptr[j]] * primes[j]) {
                    ptr[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
};