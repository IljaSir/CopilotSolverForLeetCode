class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        int[] count = new int[1 << n];
        int[] dp = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    dp[i] |= nums[j];
                }
            }
            count[dp[i]]++;
            max = Math.max(max, dp[i]);
        }
        return count[max];
    }
}