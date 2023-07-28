class Solution {
public:
    bool primeSubOperation(vector<int>& nums) {
        
        vector<int> primes;
        for (int i = 2; i < 1000; i++) {
            bool isPrime = true;
            for (auto p : primes) {
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.push_back(i);
            }
        }
        int n = nums.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    continue;
                }
                for (auto p : primes) {
                    if (p >= nums[j]) {
                        break;
                    }
                    if (nums[j] - p == nums[i]) {
                        dp[i] = max(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[n - 1] > 0;
    }
};