class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        
        int xor = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                xor ^= nums1[i] ^ nums2[j];
            }
        }
        return xor;
    }
    public int xorAllNums1(int[] nums1, int[] nums2) {
        int xor = 0;
        for (int i = 0; i < nums1.length; i++) {
            xor ^= nums1[i] * nums2.length;
        }
        for (int j = 0; j < nums2.length; j++) {
            xor ^= nums2[j] * nums1.length;
        }
        return xor;
    }
    public int xorAllNums2(int[] nums1, int[] nums2) {
        int xor = 0;
        for (int i = 0; i < nums1.length; i++) {
            xor ^= nums1[i] * nums2.length;
        }
        for (int j = 0; j < nums2.length; j++) {
            xor ^= nums2[j] * nums1.length;
        }
        return xor;
    }
    public int xorAllNums3(int[] nums1, int[] nums2) {
        int xor = 0;
        for (int i = 0; i < nums1.length; i++) {
            xor ^= nums1[i] * nums2.length;
        }
        for (int j = 0; j < nums2.length; j++) {
            xor ^= nums2[j] * nums1.length;
        }
        return xor;
    }
    public int xorAllNums4(int[] nums1, int[] nums2) {
        int xor = 0;
        for (int i = 0; i < nums1.length; i++) {
            xor ^= nums1[i] * nums2.length;
        }
        for (int j = 0; j < nums2.length; j++) {
            xor ^= nums2[j] * nums1.length;
        }
        return xor;
    }
}