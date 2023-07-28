class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                res ^= nums1[i] ^ nums2[j];
            }
        }
        return res;
    }
    public int xorAllNums2(int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            res ^= nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            res ^= nums2[j];
        }
        return res;
    }
    public int xorAllNums3(int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            res ^= nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            res ^= nums2[j];
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                res ^= nums1[i] ^ nums2[j];
            }
        }
        return res;
    }
    public int xorAllNums4(int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            res ^= nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            res ^= nums2[j];
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                res ^= nums1[i] ^ nums2[j];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            res ^= nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            res ^= nums2[j];
        }
        return res;
    }
}