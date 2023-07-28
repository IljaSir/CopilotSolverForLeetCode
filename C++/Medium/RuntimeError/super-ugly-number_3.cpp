class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        
        vector<int> ugly(n);
        ugly[0] = 1;
        int k = primes.size();
        vector<int> index(k, 0);
        for (int i = 1; i < n; ++i) {
            int min = INT_MAX;
            for (int j = 0; j < k; ++j) {
                int val = ugly[index[j]] * primes[j];
                if (val < min) {
                    min = val;
                }
            }
            ugly[i] = min;
            for (int j = 0; j < k; ++j) {
                if (ugly[index[j]] * primes[j] == min) {
                    ++index[j];
                }
            }
        }
        return ugly[n - 1];
    }
};