class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
        long sum1 = 0;
        long sum2 = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            sum1 += nums1[i];
        }
        for (int i = 0; i < len2; i++) {
            sum2 += nums2[i];
        }
        if (sum1 == sum2) {
            return 0;
        }
        if (sum1 > sum2) {
            return minOperations(nums2, nums1, k);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] diff1 = new int[len1];
        int[] diff2 = new int[len2];
        for (int i = 0; i < len1; i++) {
            diff1[i] = nums1[i] - 1;
        }
        for (int i = 0; i < len2; i++) {
            diff2[i] = 6 - nums2[i];
        }
        Arrays.sort(diff1);
        Arrays.sort(diff2);
        long diff = sum2 - sum1;
        int i = 0;
        int j = 0;
        while (j < k) {
            if (i < len1 && j < len2) {
                if (diff1[i] > diff2[j]) {
                    diff -= diff1[i];
                    i++;
                } else {
                    diff -= diff2[j];
                    j++;
                }
            } else if (i < len1) {
                diff -= diff1[i];
                i++;
            } else {
                diff -= diff2[j];
                j++;
            }
            if (diff <= 0) {
                return j;
            }
        }
        return -1;
    }
}