class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[][] dp = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return minimumXORSum(nums1, nums2, 0, 0, dp);
    }
    
    private int minimumXORSum(int[] nums1, int[] nums2, int i, int mask, int[][] dp) {
        if (i == nums1.length) {
            return 0;
        }
        if (dp[i][mask] != Integer.MAX_VALUE) {
            return dp[i][mask];
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < nums2.length; j++) {
            if ((mask & (1 << j)) == 0) {
                ans = Math.min(ans, (nums1[i] ^ nums2[j]) + minimumXORSum(nums1, nums2, i + 1, mask | (1 << j), dp));
            }
        }
        dp[i][mask] = ans;
        return ans;
    }
}