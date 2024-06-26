class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        
        vector<int> dp(n, INT_MAX);
        dp[0] = 1;
        vector<int> idx(primes.size(), 0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < primes.size(); j++) {
                dp[i] = min(dp[i], dp[idx[j]] * primes[j]);
            }
            for (int j = 0; j < primes.size(); j++) {
                if (dp[i] == dp[idx[j]] * primes[j]) {
                    idx[j]++;
                }
            }
        }
        return dp[n-1];
    }
};