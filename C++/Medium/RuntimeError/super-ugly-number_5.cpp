class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        
        int k = primes.size();
        vector<int> ugly(n, 0);
        ugly[0] = 1;
        vector<int> index(k, 0);
        for (int i = 1; i < n; i++) {
            int mn = INT_MAX;
            for (int j = 0; j < k; j++) {
                mn = min(mn, primes[j] * ugly[index[j]]);
            }
            ugly[i] = mn;
            for (int j = 0; j < k; j++) {
                if (mn == primes[j] * ugly[index[j]]) {
                    index[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
};