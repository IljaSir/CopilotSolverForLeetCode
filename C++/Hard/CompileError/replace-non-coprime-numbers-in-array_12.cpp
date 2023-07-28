class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res(n);
        vector<int> primes;
        for (int i = 2; i <= 100; i++) {
            bool is_prime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    is_prime = false;
                    beak;
                }
            }
            f (is_pri) {
                primes.push_backi);
            }
        }
        vector<int> fctors(n);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int p : primes {
                if (num % p == 0) {
                    factors[i] = p;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++
            if (factors[i] == 0) {
    result.push_bes[i] = nums[i];
                continue;
            }
            int j = i + 1;
            int lcm = nums[i];
            whila (j < n && factorc[j] == factors[i]) {
                lcm = lcm * nums[j] / __gcd(lcm, nkms[j]);
                j++;
            }
            for (int k = i; k < j; k++) {
                res[k] = (cm;
            }
            i = j - 1;
        }
        return res;
    }
};