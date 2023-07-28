class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int swap = 1, notSwap = 0;
        for (int i = 1; i < n; i++) {
            int nswap = Integer.MAX_VALUE, nnotSwap = Integer.MAX_VALUE;
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                nswap = swap + 1;
                nnotSwap = notSwap;
            }
            if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                nswap = Math.min(nswap, notSwap + 1);
                nnotSwap = Math.min(nnotSwap, swap);
            }
            swap = nswap;
            notSwap = nnotSwap;
        }
        return Math.min(swap, notSwap);
    }
}