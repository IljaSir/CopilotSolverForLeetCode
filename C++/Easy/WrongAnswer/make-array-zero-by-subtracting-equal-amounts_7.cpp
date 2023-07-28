class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int ret = 0;
        for (int i = nums.size()-1; i >= 0; --i) {
            if (i == 0) {
                ret += nums[i];
            } else {
                ret += nums[i] - nums[i-1];
            }
        }
        return ret;
    }
};