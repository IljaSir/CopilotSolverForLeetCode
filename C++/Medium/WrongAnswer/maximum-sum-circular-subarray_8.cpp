class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        
        int n = nums.size();
        int ans = nums[0];
        int sum = nums[0];
        int min_sum = nums[0];
        int max_sum = nums[0];
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            max_sum = max(max_sum + nums[i], nums[i]);
            min_sum = min(min_sum + nums[i], nums[i]);
            ans = max(ans, max(max_sum, sum - min_sum));
        }
        return ans;
    }
};