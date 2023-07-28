class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        int[] diff = new int[n];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; ++i) {
            diff[i] = nums1[i] - nums2[i];
            sum1 += nums1[i];
            sum2 += nums2[i];
        }
        if (sum1 < sum2) {
            return minOperations(nums2, nums1, k);
        }
        if (sum1 - sum2 < k) {
            return -1;
        }
        Arrays.sort(diff);
        long ans = 0;
        for (int i = 0; i < k; ++i) {
            ans += diff[n - i - 1];
        }
        return ans;
    }
}