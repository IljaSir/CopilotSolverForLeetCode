class Solution {
public:
    int distinctPrimeFactors(vector<int>& nums) {
        
        vector<int> primes;
        for (int i = 2; i <= 1000; i++) {
            bool is_prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime) {
                primes.push_back(i);
            }
        }
        int n = nums.size();
        vector<int> factors(n, 0);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < primes.size(); j++) {
                if (num % primes[j] == 0) {
                    factors[i] |= (1 << j);
                    while (num % primes[j] == 0) {
                        num /= primes[j];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            bool is_distinct = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if ((factors[i] & factors[j]) == factors[i]) {
                    is_distinct = false;
                    break;
                }
            }
            if (is_distinct) {
                ans++;
            }
        }
        return ans;
    }
};