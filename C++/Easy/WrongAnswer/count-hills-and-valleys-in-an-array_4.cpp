class Solution {
public:
    int countHillValley(vector<int>& nums) {
        
        int ans = 0;
        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                ans++;
            }
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                ans++;
            }
        }
        return ans;
    }
};