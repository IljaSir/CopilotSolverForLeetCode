class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        int[] pre1 = new int[n + 1];
        int[] pre2 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre1[i + 1] = Math.max(pre1[i], nums1[i]);
            pre2[i + 1] = Math.max(pre2[i], nums2[i]);
        }
        long ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(ans, 1L * pre1[i] * pre2[k - i]);
        }
        return ans;
    }
}