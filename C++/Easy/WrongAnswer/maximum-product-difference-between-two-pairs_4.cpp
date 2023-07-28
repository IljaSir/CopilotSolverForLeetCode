class Solution {
public:
    int maxProductDifference(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int a = nums[0], b = nums[1], c = nums[nums.size()-2], d = nums[nums.size()-1];
        return a*b - c*d;
    }
};