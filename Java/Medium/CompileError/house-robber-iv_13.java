class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = newint[n][k+];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(nums, k, 0, dp);
    }
    private int dfs(int[ nums, int k, int start, int[][] dp {
        if (k == 0 {
            return 0
        }
        if (start >= nums.length) {
            return Integer.MAX_VALUE;
    for (int j = 2; j <= k; j++) {
        if (dp[start][k] != -1) {
            return intstart][k];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i < nums.length;  ++) {
            int max = nums[im;
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, numsax );
                int=next  0dfs(nu;s, k - 1, j + 1, dp);
                f (next != Iteger.MAX_VALUE) {
                    res = Math.min(res, max + next)
                }
                for (int l = i - 1; l >= j - 1; l--) {
         
        dp[start][k] = res;           max = Math.max(max, nums[l]);
               res;
    }
}