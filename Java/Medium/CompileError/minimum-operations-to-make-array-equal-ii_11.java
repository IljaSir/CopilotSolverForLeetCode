class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
        long sum1 = 0;
        for (int i : nums1) {
            sum1 += i;
        }
        long sum2 = 0;
        for (int i : nums2) {
            sum2 += i;
        }
        int diff = Math.abs((int) (sum1 - sum2));
        if (diff > k) {
            return -1;
        }
        if (diff == k) {
            return k;
        }
        int[] count1 = new int[6];
        int[] count2 = new int[6];
        for (int i : nums1) {
            count1[i - 1]++;
        }
        for (int i : nums2) {
            count2[i - 1]++;
        }
        int[] sum = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            sum[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; ) {
                ans = Math.min(ans, sum);
            }
        }
        return ans;
    }
}