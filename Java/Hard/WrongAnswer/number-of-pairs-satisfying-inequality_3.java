class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        
        int n = nums1.length;
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = nums1[i] - nums2[i] - diff;
            int y = nums1[i] - nums2[i] + diff;
            ans += upperBound(nums1, y) - upperBound(nums1, x);
        }
        return ans;
    }
    private int upperBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + r >> 1;
            if (a[m] > x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}