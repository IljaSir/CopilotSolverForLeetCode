class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int result = 0;
        for (int i = 1; i < nums.size(); i += 2) {
            if (nums[i] <= nums[i - 1]) {
                result += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        for (int i = nums.size() - 2; i >= 0; i -= 2) {
            if (nums[i] <= nums[i + 1]) {
                result += nums[i + 1] - nums[i] + 1;
                nums[i] = nums[i + 1] + 1;
            }
        }
        return result;
    }
};