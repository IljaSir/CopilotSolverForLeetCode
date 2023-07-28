class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> ans(n);
        vector<int> primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
        for(int i = 0; i < n; i++){
            ans[i] = nums[i];
            for(int p: primes){
                if(p > nums[i]) break;
                if(nums[i] % p == 0){
                    ans[i] = p;
                    break;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(ans[i] == nums[i]) continue;
            int j = i + 1;
            while(j < n && ans[j] == nums[j]) j++;
            if(j == n) break;
            ans[i] = ans[j] = nums[i] * nums[j] / ans[i];
            i = j - 1;
        }
        return ans;
    }
};