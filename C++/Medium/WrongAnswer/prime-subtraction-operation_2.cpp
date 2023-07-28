class Solution {
public:
    bool primeSubOperation(vector<int>& nums) {
        
        int n = nums.size();
        vector<bool> isPrime(1001, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i < 1001; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j < 1001; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        vector<int> primes;
        for (int i = 0; i < 1001; ++i) {
            if (isPrime[i]) {
                primes.push_back(i);
            }
        }
        vector<int> dp(n, 0);
        for (int i = 0; i < n; ++i) {
            dp[i] = nums[i];
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    auto it = lower_bound(primes.begin(), primes.end(), nums[i] - dp[j]);
                    if (it != primes.end() && *it < nums[i]) {
                        dp[i] = max(dp[i], dp[j] + *it);
                    }
                }
            }
        }
        return dp[n - 1] > nums[n - 1];
    }
};