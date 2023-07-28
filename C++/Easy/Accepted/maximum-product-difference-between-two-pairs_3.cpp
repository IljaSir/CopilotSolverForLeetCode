class Solution {
public:
    int maxProductDifference(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int i = nums.size() - 1;
        return nums[i] * nums[i - 1] - nums[0] * nums[1];
    }
};