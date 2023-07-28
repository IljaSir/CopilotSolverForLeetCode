class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        
        return helper(nums, k) - helper(nums, k - 1);
    }
};