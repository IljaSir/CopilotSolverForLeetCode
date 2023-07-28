class Solution {
public:
    int totalSteps(vector<int>& nums) {
        
        int steps = 0;
        int i = 1;
        while (i < nums.size()) {
            if (nums[i] < nums[i - 1]) {
                steps++;
                nums[i] = nums[i - 1];
            }
            i++;
        }
        return steps;
    }
};