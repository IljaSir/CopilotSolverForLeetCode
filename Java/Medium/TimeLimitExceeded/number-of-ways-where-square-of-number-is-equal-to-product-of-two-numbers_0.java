class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long product = (long) nums1[i] * nums1[j];
                for (int k = 0; k < nums2.length; k++) {
                    if (product == (long) nums2[k] * nums2[k]) {
                        count++;
                    }
                }
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                long product = (long) nums2[i] * nums2[j];
                for (int k = 0; k < nums1.length; k++) {
                    if (product == (long) nums1[k] * nums1[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}