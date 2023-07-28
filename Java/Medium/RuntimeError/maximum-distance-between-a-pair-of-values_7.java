class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            int l = i, r = nums2.length - 1;
            while (l < r) {
                int m = l + (r - l + 1) / 2;
                if (nums1[i] <= nums2[m]) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            if (i <= l && nums1[i] <= nums2[l]) {
                max = Math.max(max, l - i);
            }
        }
        return max;
    }
}