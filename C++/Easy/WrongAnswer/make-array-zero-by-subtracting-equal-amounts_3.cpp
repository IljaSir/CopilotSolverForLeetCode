class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int min = 101;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > 0 && nums[i] < min) {
                min = nums[i];
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > 0) {
                count++;
                nums[i] -= min;
            }
        }
        if (count == 0) {
            return 0;
        }
        return count + minimumOperations(nums);
    }
};