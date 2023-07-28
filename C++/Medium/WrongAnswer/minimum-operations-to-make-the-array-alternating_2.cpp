class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 1; i < n; i += 2) {
            if (nums[i] <= nums[i - 1]) {
                ans += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i -= 2) {
            if (nums[i] <= nums[i + 1]) {
                ans += nums[i + 1] - nums[i] + 1;
                nums[i] = nums[i + 1] + 1;
            }
        }
        return ans;
    }
};