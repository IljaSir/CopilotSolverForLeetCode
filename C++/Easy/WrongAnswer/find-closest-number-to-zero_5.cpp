class Solution {
public:
    int findClosestNumber(vector<int>& nums) {
        
        int min = 100000;
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (abs(nums[i]) < min) {
                min = abs(nums[i]);
            }
            if (abs(nums[i]) == min) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
        }
        return max;
    }
};