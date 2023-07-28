class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[][] dp = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return minimumXORSum(0, 0, nums1, nums2, dp);
    }
    
    private int minimumXORSum(int i, int mask, int[] nums1, int[] nums2, int[][] dp) {
        if (i == nums1.length) {
            return 0;
        }
        if (dp[i][mask] != Integer.MAX_VALUE) {
            return dp[i][mask];
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < nums2.length; j++) {
            if ((mask & (1 << j)) != 0) {
                continue;
            }
            res = Math.min(res, minimumXORSum(i + 1, mask | (1 << j), nums1, nums2, dp) + (nums1[i] ^ nums2[j]));
        }
        return dp[i][mask] = res;
    }
}