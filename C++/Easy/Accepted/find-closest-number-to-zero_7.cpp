class Solution {
public:
    int findClosestNumber(vector<int>& nums) {
        
        int n = nums.size();
        int min = abs(nums[0]);
        int max = nums[0];
        for (int i = 1; i < n; ++i) {
            if (abs(nums[i]) < min) {
                min = abs(nums[i]);
                max = nums[i];
            } else if (abs(nums[i]) == min) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
        }
        return max;
    }
};