class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] swap = new int[n];
        int[] noSwap = new int[n];
        Arrays.fill(swap, Integer.MAX_VALUE);
        Arrays.fill(noSwap, Integer.MAX_VALUE);
        swap[0] = 1;
        noSwap[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                swap[i] = swap[i - 1] + 1;
                noSwap[i] = noSwap[i - 1];
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                swap[i] = Math.min(swap[i], noSwap[i - 1] + 1);
                noSwap[i] = Math.min(noSwap[i], swap[i - 1]);
            }
        }
        return Math.min(swap[n - 1], noSwap[n - 1]);
    }
}