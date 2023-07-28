class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& nums) {
        
        vector<int> primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199};
        vector<int> coprimes(200, 0);
        for(int i = 0; i < primes.size(); ++i){
            for(int j = i+1; j < primes.size(); ++j){
                coprimes[primes[i]*primes[j]] = 1;
            }
        }
        vector<int> result;
        for(int i = 0; i < nums.size(); ++i){
            if(coprimes[nums[i]] == 0){
                result.push_back(nums[i]);
            }else{
                int j = i+1;
                int lcm = nums[i];
                while(j < nums.size() && coprimes[lcm*nums[j]] == 1){
                    lcm *= nums[j];
                    ++j;
                }
                result.push_back(lcm);
                i = j-1;
            }
        }
        return result;
    }
};