class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
        }
        if (sum1 < sum2) {
            return minOperations(nums2, nums1, k);
        }
        long target = sum1 - sum2;
        if (target < k) {
            return -1;
        }
        int[] count1 = new int[6];
        int[] count2 = new int[6];
        for (int i = 0; i < n; i++) {
            count1[nums1[i] - 1]++;
            count2[nums2[i] - 1]++;
        }
        long[] sumCount1 = new long[6];
        long[] sumCount2 = new long[6];
        for (int i = 1; i < 6; i++) {
            sumCount1[i] = sumCount1[i - 1] + count1[i - 1];
            sumCount2[i] = sumCount2[i - 1] + count2[i - 1];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            long t = target - i;
            if (t > 5 * k || t < 0) {
                continue;
            }
            int j = (int) (t / 5);
            int l = (int) (t % 5);
            long c1 = sumCount1[5] - sumCount1[5 - j];
            long c2 = sumCount2[l];
            ans = Math.min(ans, c1 + c2);
        }
        return ans;
    }
}