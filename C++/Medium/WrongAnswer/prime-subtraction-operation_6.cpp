class Solution {
public:
    bool primeSubOperation(vector<int>& nums) {
        
        vector<int> primes;
        for (int i = 2; i <= 1000; i++) {
            bool is_prime = true;
            for (int j = 2; j <= sqrt(i); j++) {
                if (i % j == 0) {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime) {
                primes.push_back(i);
            }
        }
        vector<int> dp(nums.size(), 0);
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < primes.size(); j++) {
                if (primes[j] < nums[i]) {
                    if (i == 0) {
                        dp[i] = max(dp[i], primes[j]);
                    } else {
                        dp[i] = max(dp[i], dp[i - 1] + primes[j]);
                    }
                } else {
                    break;
                }
            }
            if (i > 0 && dp[i] <= dp[i - 1]) {
                return false;
            }
        }
        return true;
    }
};