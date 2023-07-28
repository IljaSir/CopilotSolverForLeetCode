class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        
        int n = nums1.length;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums1[i] - nums2[i] + diff;
            b[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long res = 0;
        for (int i = 0; i < n; i++) {
            int j = upperBound(a, b[i]);
            res += j;
        }
        return res;
    }
    public int upperBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] <= x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}