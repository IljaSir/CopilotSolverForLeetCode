class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            res += binarySearch(nums1[i] - diff, nums2, i + 1);
        }
        return res;
    }

    private long binarySearch(int target, int[] nums2, int start) {
        int l = start, r = nums2.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums2[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums2[r] >= target ? nums2.length - r : 0;
    }
}