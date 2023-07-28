class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0) return 0;
        int maxsum = nums[0];
        int minsum = nums[0];
        int maxval = nums[0];
        int minval = nums[0];
        for (int i = 1; i < n; i++) {
            maxsum = max(nums[i], maxsum + nums[i]);
            maxval = max(maxval, maxsum);
            minsum = min(nums[i], minsum + nums[i]);
            minval = min(minval, minsum);
        }
        return max(abs(maxval), abs(minval));
    }
};