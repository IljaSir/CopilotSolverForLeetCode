class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        
        return atMostK(nums, k) - atMostK(nums, k-1);
    }
};