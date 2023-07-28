class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        int maxVal = 0;
        for (int num : nums) {
            maxVal = max(maxVal, num);
        }
        vector<int> sum(maxVal + 1);
        for (int num : nums) {
            sum[num] += num;
        }
        return rob(sum);
    }
    int rob(vector<int>& nums) {
        int size = nums.size();
        if (size == 1) {
            return nums[0];
        }
        vector<int> dp(size);
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[size - 1];
    }
};