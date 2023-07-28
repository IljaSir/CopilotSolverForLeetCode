class Solution {
public:
    int totalSteps(vector<int>& nums) {
        
        int n = nums.size();
        int steps = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                steps += nums[i - 1] - nums[i];
                nums[i] = nums[i - 1];
            }
        }
        return steps;
    }
};