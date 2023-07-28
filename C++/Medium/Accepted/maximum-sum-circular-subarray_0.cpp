class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        
        int n = nums.size();
        int max_so_far = nums[0], max_ending_here = nums[0];
        int min_so_far = nums[0], min_ending_here = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            max_ending_here = max(max_ending_here + nums[i], nums[i]);
            max_so_far = max(max_so_far, max_ending_here);
            min_ending_here = min(min_ending_here + nums[i], nums[i]);
            min_so_far = min(min_so_far, min_ending_here);
        }
        if (sum == min_so_far) return max_so_far;
        return max(max_so_far, sum - min_so_far);
    }
};