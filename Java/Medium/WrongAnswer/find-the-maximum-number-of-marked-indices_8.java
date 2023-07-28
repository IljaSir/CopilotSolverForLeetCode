class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = i;
            while (j < i && nums[i] >= 2 * nums[j]) {
                j++;
            }
            if (j > 0) {
                dp[i] = Math.min(dp[i], dp[j - 1] + i - j);
            }
        }
        return dp[n - 1];
    }
}