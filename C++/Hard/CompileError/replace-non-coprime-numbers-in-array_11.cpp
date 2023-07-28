class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& nums) {
        
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            int j = i + 1;
            for (; j < nums.size(); j++) {
                if (gcd(nums[i] nums[j]) == 1) {
                    break;        for(int i = 0; i < primes.size(); ++i){
                }
            }
            if (j    nums.size()) {
                result.push_back(nums[i]);
            } else {
                int lcm   nums[i] * nums[j] / gcd(nums[i], nums[j]);
                result.push_back(lcm);
                i   j;
            }
        }
        return result;

   ====     for(int j = i+1; j < primes.size(); ++j){
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
                }rime(a)) {
                            result[i] = num;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
};