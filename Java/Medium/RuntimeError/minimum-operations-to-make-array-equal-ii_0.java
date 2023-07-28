class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < k; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
        }
        long diff = sum2 - sum1;
        if (diff == 0) {
            return 0;
        }
        if (diff < 0) {
            diff = -diff;
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int n = nums1.length;
        int m = nums2.length;
        int[] cnt1 = new int[6];
        int[] cnt2 = new int[6];
        for (int i = 0; i < n; i++) {
            cnt1[nums1[i] - 1]++;
        }
        for (int i = 0; i < m; i++) {
            cnt2[nums2[i] - 1]++;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                long need = diff - (j - i);
                if (need > 0 && need % 5 == 0) {
                    long cnt = need / 5 + cnt1[i] + cnt2[j];
                    if (cnt <= k) {
                        ans = Math.min(ans, cnt);
                    }
                }
            }
        }
        return ans == Long.MAX_VALUE ? -1 : ans;
    }
}