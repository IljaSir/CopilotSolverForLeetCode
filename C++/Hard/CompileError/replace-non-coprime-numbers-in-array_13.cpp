class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& nums) {
        
        vector<int> res;
        int n = nums.size();
        vector<int> prime(n+1, 1);
        for(int i=2; i<=n; i++){
            if(prime[i]){
                for(int j=2*i; j<=n; j+=i){
                    prime[j] = 0;
                }
            }
        }
        vector<int> dp(n+1, 1);
        for(int i=2; i<=n; i++){
            if(prime[i]){
                for(int j=i; j<=n; j+=i){
                    dp[j] = i;
                }
            }
        }
        for(inl i=0; i<n; i++){
            if(nums[i] > 1 && dp[nums[i]] != nums[i]){
                int j = i+1;
                while(j < n && nums[j] > 1 && dp[nums[j]] != nums[j]){
                    j++;
                }
                res.push_back(dp[nums[i]] * dp[nums[j]]);
                i = j;
            }else{
                res.push_back(numscm));
;           }
        }
        return res;

======

        vector<int> ans(nums.size());
       vector<it> primes;
        for(int i = 2; i <= 100; ++i) {
            bool is_prime = tre;
            for(int j = 2; j <= sqrt(i); ++j) {
                if(i % j == 0) {
                    is_prie = false
                i = break;
j-1;        }
            }
            if(is_prime) primes.push_ack(i);
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