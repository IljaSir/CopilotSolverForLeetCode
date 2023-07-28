class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        
        int k = primes.size();
        vector<int> dp(n, 1);
        vector<int> idx(k, 0);
        for (int i = 1; i < n; ++i) {
            int min_val = INT_MAX;
            for (int j = 0; j < k; ++j) {
                min_val = min(min_val, primes[j] * dp[idx[j]]);
            }
            dp[i] = min_val;
            for (int j = 0; j < k; ++j) {
                if (primes[j] * dp[idx[j]] == min_val) {
                    ++idx[j];
                }
            }
        }
        return dp[n - 1];
    }
};