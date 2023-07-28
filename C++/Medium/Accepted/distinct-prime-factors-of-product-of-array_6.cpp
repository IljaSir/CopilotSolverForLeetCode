class Solution {
public:
    int distinctPrimeFactors(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> primes;
        for (int i = 2; i < 1000; i++) {
            if (isPrime(i)) {
                primes.push_back(i);
            }
        }
        int res = 0;
        for (int i = 0; i < primes.size(); i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] % primes[i] == 0) {
                    count++;
                }
            }
            if (count > 0) {
                res++;
            }
        }
        return res;
    }
    bool isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
};