class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& nums) {
        
        vector<int> res;
        vector<int> primes = getPrimes(100);
        for (int i = 0; i < nums.size(); i++) {
            int n = nums[i];
            int p = 0;
            int lcm = 1;
            bool found = false;
            while (n != 1 && p < primes.size()) {
                if (n % primes[p] == 0) {
                    found = true;
                    lcm = lcm * primes[p] / __gcd(lcm, primes[p]);
                    while (n % primes[p] == 0) {
                        n /= primes[p];
                    }
                }
                p++;
            }
            if (found) {
                res.push_back(lcm);
            } else {
                res.push_back(nums[i]);
            }
        }
        return res;
    }
    
    vector<int> getPrimes(int n) {
        vector<int> res;
        vector<bool> sieve(n+1, true);
        for (int i = 2; i <= n; i++) {
            if (sieve[i]) {
                res.push_back(i);
                for (int j = i+i; j <= n; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return res;
    }
};