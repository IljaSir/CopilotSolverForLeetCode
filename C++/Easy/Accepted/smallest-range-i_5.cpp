class Solution {
public:
    int smallestRangeI(vector<int>& nums, int k) {
        
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] < min) min = nums[i];
            else if (nums[i] > max) max = nums[i];
        }
        return max - min > 2 * k ? max - min - 2 * k : 0;
    }
};