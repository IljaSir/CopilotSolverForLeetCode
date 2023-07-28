class Solution {
    public int minimumDifference(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int half = sum / 2;
        int[] dp = new int[half + 1];
        for (int num : nums) {
            for (int i = half; i >= num; i--) {
                dp[i] = Math.max(dp[i], dp[i - num] + num);
            }
        }
        return sum - 2 * dp[half];
    }
}