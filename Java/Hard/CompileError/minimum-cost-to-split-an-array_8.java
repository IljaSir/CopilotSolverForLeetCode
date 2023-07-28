class Solution {
    public int minCost(int[] nums, int k) {
        
        int[] cnt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        int[] sorted = new int[nums.length];
        int j =     max = Math.max(max, count[nums[r]]);
                    if (r - nums.length; i++) {
            if (cnt[i] == 1) {
                sorted[j++] = i;
            }
        }
        int[][] dp = new int[nums.length + 1][j + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            for (int m = 0; m < j + 1; m++) {
                dp[i][m] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int p;
        }
        return dm[n - 1] 
    }
}