class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return dfs(nums1, nums2, 0, 0, dp);
    }

    public int dfs(int[] nums1, int[] nums2, int i, int mask, int[][] dp) {
        if (i == nums1.length) {
            return 0;
        }
        if (dp[i][mask] != Integer.MAX_VALUE) {
            return dp[i][mask];
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < nums2.length; j++) {
            if (((mask >> j) & 1) == 0) {
                res = Math.min(res, (nums1[i] ^ nums2[j]) + dfs(nums1, nums2, i + 1, mask | (1 << j), dp));
            }
        }
        dp[i][mask] = res;
        return res;
    }
}