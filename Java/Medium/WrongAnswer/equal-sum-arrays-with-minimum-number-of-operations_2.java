class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
        }
        if (sum1 == sum2) {
            return 0;
        }
        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }
        int[] diff = new int[6];
        for (int i = 0; i < nums1.length; i++) {
            diff[nums1[i] - 1]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            diff[6 - nums2[i]]++;
        }
        int count = 0;
        int target = sum2 - sum1;
        for (int i = 5; i >= 0 && target > 0; i--) {
            int delta = Math.min(diff[i], (target + i) / (i + 1));
            count += delta;
            target -= delta * (i + 1);
        }
        return target > 0 ? -1 : count;
    }
}