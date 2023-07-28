class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        
        int size = primes.size();
        vector<int> dp(n, INT_MAX);
        vector<int> pointers(size, 0);
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < size; j++) {
                dp[i] = min(dp[i], dp[pointers[j]] * primes[j]);
            }
            for (int j = 0; j < size; j++) {
                if (dp[i] == dp[pointers[j]] * primes[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n - 1];
    }
};