class Solution {
public:
    int rob(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 1) return nums[0];
        return max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }
};