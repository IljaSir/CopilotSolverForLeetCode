class Solution {
public:
    bool primeSubOperation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> primes;
        for (int i = 2; i < 1000; ++i) {
            bool is_prime = true;
            for (int j = 2; j * j <= i; ++j) {
                if (i % j == 0) {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime) {
                primes.push_back(i);
            }
        }
        vector<int> dp(n, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < primes.size(); ++j) {
                if (primes[j] >= nums[i]) {
                    break;
                }
                if (i == 0 || dp[i - 1] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[n - 1] == 1;
    }
};