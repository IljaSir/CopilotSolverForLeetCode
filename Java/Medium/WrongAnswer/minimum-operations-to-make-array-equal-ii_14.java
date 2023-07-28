class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            return minOperations(nums2, nums1, k);
        }
        if (k > n + m) {
            return -1;
        }
        int[] diff = new int[n + m];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            diff[idx++] = nums1[i] - 1;
        }
        for (int i = 0; i < m; i++) {
            diff[idx++] = 6 - nums2[i];
        }
        Arrays.sort(diff);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += diff[i];
        }
        if (sum >= k) {
            return k;
        }
        long ans = Long.MAX_VALUE;
        for (int i = k; i < n + m; i++) {
            sum += diff[i] - diff[i - k];
            if (sum >= k) {
                ans = Math.min(ans, sum);
            }
        }
        return ans;
    }
}