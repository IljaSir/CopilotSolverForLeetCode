class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        
        vector<int> ugly(n, INT_MAX);
        vector<int> last(primes.size(), 0);
        ugly[0] = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < primes.size(); ++j) {
                ugly[i] = min(ugly[i], ugly[last[j]] * primes[j]);
            }
            for (int j = 0; j < primes.size(); ++j) {
                if (ugly[i] == ugly[last[j]] * primes[j]) {
                    ++last[j];
                }
            }
        }
        return ugly[n - 1];
    }
};