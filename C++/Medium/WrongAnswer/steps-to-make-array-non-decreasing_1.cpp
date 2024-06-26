class Solution {
public:
    int totalSteps(vector<int>& nums) {
        
        int ans = 0;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] < nums[i - 1]) {
                ans += nums[i - 1] - nums[i];
                nums[i] = nums[i - 1];
            }
        }
        return ans;
    }
};