class Solution {
public:
    long long minimalKSum(vector<int>& nums, int k) {
        
        long long ret = 0;
        sort(nums.begin(), nums.end());
        for(int i=0;i<nums.size();i++){
            if(i==0 || nums[i] != nums[i-1]){
                ret += nums[i];
                k--;
            }
            if(k==0) break;
        }
        ret += k;
        return ret;
    }
};