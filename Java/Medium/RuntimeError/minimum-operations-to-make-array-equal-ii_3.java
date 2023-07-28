class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
        if (nums1.length * 6 < k || nums2.length * 6 < k) {
            return -1;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        for (int num : nums2) {
            sum2 += num;
        }
        if (sum1 == sum2 + k) {
            return 0;
        }
        if (sum1 < sum2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int sum = sum1;
            sum1 = sum2;
            sum2 = sum;
        }
        int diff = sum1 - sum2;
        int[] count1 = new int[6];
        int[] count2 = new int[6];
        for (int num : nums1) {
            count1[num - 1]++;
        }
        for (int num : nums2) {
            count2[6 - num]++;
        }
        int[] sum1s = new int[6];
        int[] sum2s = new int[6];
        sum1s[0] = count1[0];
        sum2s[0] = count2[0];
        for (int i = 1; i < 6; i++) {
            sum1s[i] = sum1s[i - 1] + count1[i];
            sum2s[i] = sum2s[i - 1] + count2[i];
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            int j = k - i;
            if (j < 0 || j > 6) {
                continue;
            }
            long sum = sum1s[i] + sum2s[j];
            long s = sum1 - sum2 - (i + 1) * (sum1s[i] - (i == 0 ? 0 : sum1s[i - 1])) + (j + 1) * (sum2s[j] - (j == 0 ? 0 : sum2s[j - 1]));
            if (s <= diff) {
                min = Math.min(min, sum);
            }
        }
        return min;
    }
}