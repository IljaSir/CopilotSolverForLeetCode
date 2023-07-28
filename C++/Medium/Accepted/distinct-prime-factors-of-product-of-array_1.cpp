class Solution {
public:
    int distinctPrimeFactors(vector<int>& nums) {
        
        int maxVal = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
            }
        }
        vector<int> primes = getPrimes(maxVal);
        if (primes.size() == 0) {
            return 0;
        }
        unordered_set<int> primeSet(primes.begin(), primes.end());
        unordered_map<int, int> primeCount;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums[i];
            for (int j = 0; j < primes.size(); j++) {
                int prime = primes[j];
                if (prime > val) {
                    break;
                }
                if (val % prime == 0) {
                    primeCount[prime]++;
                    while (val % prime == 0) {
                        val /= prime;
                    }
                }
            }
        }
        return primeCount.size();
    }
    
    vector<int> getPrimes(int n) {
        vector<bool> prime(n + 1, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        vector<int> primes;
        for (int i = 0; i <= n; i++) {
            if (prime[i]) {
                primes.push_back(i);
            }
        }
        return primes;
    }
};