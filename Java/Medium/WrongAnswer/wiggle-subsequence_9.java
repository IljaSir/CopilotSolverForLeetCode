class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        if(nums.length < 2) return nums.length;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int prev = nums[0];
        int i = 1;
        while(i < nums.length && prev == nums[i]) {
            i++;
        }
        if(i == nums.length) return 1;
        dp[i] = 2;
        int sign = nums[i] - prev;
        for(int j = i + 1; j < nums.length; j++) {
            if(nums[j] - prev > 0 && sign < 0) {
                dp[j] = dp[j-1] + 1;
                sign = 1;
            } else if(nums[j] - prev < 0 && sign > 0) {
                dp[j] = dp[j-1] + 1;
                sign = -1;
            } else {
                dp[j] = dp[j-1];
            }
            prev = nums[j];
        }
        return dp[nums.length - 1];
    }
}