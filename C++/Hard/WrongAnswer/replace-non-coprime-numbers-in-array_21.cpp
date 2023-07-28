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
    }
};