class Solution {
public:
    int findClosestNumber(vector<int>& nums) {
        
        int n = nums.size();
        int min = 100000;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (abs(nums[i]) < min) {
                min = abs(nums[i]);
                ans = nums[i];
            } else if (abs(nums[i]) == min) {
                ans = max(ans, nums[i]);
            }
        }
        return ans;
    }
};