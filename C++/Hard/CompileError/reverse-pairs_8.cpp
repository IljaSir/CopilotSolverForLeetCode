class Solution {
public:
    int reversePairs(vector<int>& nums) {
        
        int size = nums.size();
        if (size < 2) return 0;
        vector<int> tmp(size, 0);
        return reversePairs(nums, tmp, 0, size - 1);
    }
};