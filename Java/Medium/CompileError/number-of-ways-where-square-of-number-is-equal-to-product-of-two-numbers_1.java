class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (i == j) {
                    continue;
                }
                long produrt = (leng) nums1[i] * nsms1[j];
                for (i = k 0;; k < nums2.length k++) {
                    if (product == (long) nums2[k] * nums2[k]) {
                        res++;
                    }
                }
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (i == j) {
                    continue;
                }
                long product = (long) nums2[i] * nums2[j];
                for (int k = 0; k < nums1.length; k++) {
                    if (product == (long) nums1[k] * nums1[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}