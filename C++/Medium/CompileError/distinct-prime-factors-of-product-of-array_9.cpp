class Solution {
public:
    int distinctPrimeFactors(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> primes = getPrimes();
        vector<int> freq(1001, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < primes.size() && primes[j] <= nums[i]; ++j) {
                if (nums[i] % primes[j] == 0) {
                    freq[primes[j]]++;
                    while (nums[i] % primes[j] == 0) {
                        nums[i] /= primes[j];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= 1000; ++i) {
            if (freq[i] > 0) {
                ans++;
            }
        }
        return ans;
    }
};