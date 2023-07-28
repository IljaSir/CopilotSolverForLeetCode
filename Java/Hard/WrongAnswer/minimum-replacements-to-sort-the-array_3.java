class Solution {
    public long minimumReplacement(int[] nums) {
        
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 2;
            } else {
                nums[i] = 1;
            }
        }
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (i > 0 && nums[i] == 2 && nums[i - 1] == 2) {
                dp[i] = dp[i - 1] + 2;
            }
            max = Math.max(max, dp[i]);
        }
        return (nums.length - max + 1) / 2;
    }
}