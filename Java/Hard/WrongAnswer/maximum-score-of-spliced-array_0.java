class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] prefix1 = new int[n];
        int[] prefix2 = new int[n];
        prefix1[0] = nums1[0];
        prefix2[0] = nums2[0];
        for (int i = 1; i < n; i++) {
            prefix1[i] = prefix1[i - 1] + nums1[i];
            prefix2[i] = prefix2[i - 1] + nums2[i];
        }
        int[] max1 = new int[n];
        int[] max2 = new int[n];
        max1[0] = nums1[0];
        max2[0] = nums2[0];
        for (int i = 1; i < n; i++) {
            max1[i] = Math.max(max1[i - 1], nums1[i]);
            max2[i] = Math.max(max2[i - 1], nums2[i]);
        }
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            max[i] = Math.max(prefix1[i], prefix2[i]);
        }
        int ans = max[n - 1];
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, max1[i] + prefix2[n - 1] - prefix2[i]);
            ans = Math.max(ans, max2[i] + prefix1[n - 1] - prefix1[i]);
        }
        return ans;
    }
}