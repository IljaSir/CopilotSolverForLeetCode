class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        
        int min = nums[0];
        int maxDiff = -1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] > min) {
                maxDiff = max(maxDiff, nums[i] - min);
            }
            min = min(min, nums[i]);
        }
        return maxDiff;
    }
};