class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        
        int len = nums1.length;
        int[] keep = new int[len];
        int[] swap = new int[len];
        keep[0] = 0;
        swap[0] = 1;
        for (int i = 1; i < len; i++) {
            keep[i] = swap[i] = len;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                keep[i] = keep[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                keep[i] = Math.min(keep[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], keep[i - 1] + 1);
            }
        }
        return Math.min(keep[len - 1], swap[len - 1]);
    }
}