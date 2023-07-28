class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int ret = 0;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] > nums[i-1]) {
                ret += nums[i] - nums[i-1];
            }
        }
        return ret;
    }
};