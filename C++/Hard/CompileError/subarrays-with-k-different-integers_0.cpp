class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
};