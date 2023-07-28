class Solution {
public:
    int findClosestNumber(vector<int>& nums) {
        
        int result = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (abs(nums[i]) < abs(result)) {
                result = nums[i];
            } else if (abs(nums[i]) == abs(result)) {
                result = max(result, nums[i]);
            }
        }
        return result;
    }
};