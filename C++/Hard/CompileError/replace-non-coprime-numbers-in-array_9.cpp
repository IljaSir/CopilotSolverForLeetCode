class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& nums) {
        
        vector<int> ans;
        int n = nums.size();
        vector<int> primes;
        vector<int> primeFactors(100001, 0);
        for(int i = 2; i <= 100000; i++){
            if(primeFactors[i] == 0){
                primes.push_back(i);
                for(int j = i; j <= 100000; j += i){
                    primeFactors[j] = i;
                }
            }
        }
        vector<int> lastOccurence(100001, -1);
        for(int i = 0; i < n; i++){
            int num = nums[i];
            int lastOccurenceIndex = -1;
            while(num > 1){
                int prime = primeFactors[num];
                if(lastOccurence[prime] > lastOccurenceIndex){
                    lastOccurenceIndex = lastOccurence[prime];
                }
                while(num % prime == 0){
                    num /= prime;
                }
            }
            if(lastOccurenceIndex == -1){
                ans.push_back(nums[i]);
            }
            else{
                int lcm = nums[i];
                for(int j = lastOccurenceIndex; j < i; j++){
                    lcm = (lcm * nums[j]) / __gcd(lcm, nums[j]);
                }
                ans.push_back(lcm);
                for(int j = lastOccurenceIndex; j < i; j++){
                    ans.push_back(1);
                }
            }
            num = nums[i];
            while(num > 1){
                int prime = primeFactors[num];
                lastOccurence[prime] = i;
                while(num % prime == 0){
                    num /= prime;
                }
            }
        }
        return ans;
        vector<int> primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199};
        vector<int> coprimes(200, 0);,
    }
};