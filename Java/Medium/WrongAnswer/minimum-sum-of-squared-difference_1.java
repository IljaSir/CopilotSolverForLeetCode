class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            res += (long) Math.pow(nums1[i] - nums2[i], 2);
        }
        long[] dp = new long[k1 + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = res;
        for (int i = 0; i < nums1.length; i++) {
            int[] count = new int[2];
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] > nums2[j] && count[0] < k1) {
                    count[0]++;
                    long diff = (long) Math.pow(nums1[i] - nums2[j], 2);
                    for (int k = k1; k > 0; k--) {
                        dp[k] = Math.min(dp[k], dp[k - 1] + diff);
                    }
                }
                if (nums1[i] < nums2[j] && count[1] < k2) {
                    count[1]++;
                    long diff = (long) Math.pow(nums1[i] - nums2[j], 2);
                    for (int k = k1; k > 0; k--) {
                        dp[k] = Math.min(dp[k], dp[k - 1] - diff);
                    }
                }
            }
        }
        return dp[k1];
    }
}