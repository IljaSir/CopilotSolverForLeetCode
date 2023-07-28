class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& nums) {
        
        vector<int> ans(nums.size());
        vector<int> primes;
        for(int i = 2; i <= 100; ++i) {
            bool is_prime = true;
            for(int j = 2; j <= sqrt(i); ++j) {
                if(i % j == 0) {
                    is_prime = false;
                    break;
                }
            }
            if(is_prime) primes.push_back(i);
        }
        vector<int> first_occur(101, -1);
        for(int i = 0; i < nums.size(); ++i) {
            int num = nums[i];
            int lcm = 1;
            for(int j = 0; j < primes.size(); ++j) {
                int prime = primes[j];
                if(num % prime == 0) {
                    if(first_occur[prime] != -1) {
                        lcm = lcm * prime / __gcd(lcm, prime);
                    }
                    while(num % prime == 0) num /= prime;
                }
            }
            if(num != 1) {
                if(first_occur[num] != -1) {
                    lcm = lcm * num / __gcd(lcm, num);
                }
            }
            ans[i] = lcm;
            for(int j = 0; j < primes.size(); ++j) {
                int prime = primes[j];
                if(lcm % prime == 0) {
                    first_occur[prime] = i;
                }
            }
        }
        return ans;
    }
};