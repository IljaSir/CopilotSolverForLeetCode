class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        
        vector<int> ugly(n, INT_MAX);
        ugly[0] = 1;
        vector<int> idx(primes.size(), 0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < primes.size(); j++) {
                ugly[i] = min(ugly[i], ugly[idx[j]] * primes[j]);
            }
            for (int j = 0; j < primes.size(); j++) {
                if (ugly[i] == ugly[idx[j]] * primes[j]) {
                    idx[j]++;
                }
            }
        }
        return ugly[n-1];
    }
};