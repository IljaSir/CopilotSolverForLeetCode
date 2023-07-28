class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        
        return atMost(nums, k) - atMost(nums, k - 1);
    }
};