class Solution {
public:
    int maxProductDifference(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        return nums.back()*nums[nums.size()-2]-nums.front()*nums[1];
    }
};