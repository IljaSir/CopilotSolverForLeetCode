class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] dp = new int[6];
        for (int i = 0; i < n; i++) {
            int[] ndp = new int[6];
            for (int j = 0; j < 6; j++) {
                ndp[j] = Integer.MAX_VALUE;
            }
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (nums1[i] != nums2[i]) {
                        if (nums1[i] != j && nums2[i] != k) {
                            ndp[k] = Math.min(ndp[k], dp[j] + k);
                        }
                    } else {
                        if (nums1[i] != j) {
                            ndp[k] = Math.min(ndp[k], dp[j] + k);
                        }
                    }
                }
            }
            dp = ndp;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            res = Math.min(res, dp[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}