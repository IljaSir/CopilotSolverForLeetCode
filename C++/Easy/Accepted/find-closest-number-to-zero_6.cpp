class Solution {
public:
    int findClosestNumber(vector<int>& nums) {
        
        int n = nums.size();
        int closest = nums[0];
        int min = abs(nums[0]);
        for (int i = 1; i < n; i++) {
            if (abs(nums[i]) < min) {
                min = abs(nums[i]);
                closest = nums[i];
            } else if (abs(nums[i]) == min) {
                closest = max(closest, nums[i]);
            }
        }
        return closest;
    }
};