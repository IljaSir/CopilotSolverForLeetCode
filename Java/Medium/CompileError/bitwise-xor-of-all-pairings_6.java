class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        
        int xor = 0;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                xor ^= (nums1[i] ^ nums2[j]);
            }
        }
        return xor;
    }
    
    public int xorAllNums2(int[] nums1, int[] nums2) {
        int xor = 0;
        for(int i = 0; i < nums1.length; i++) {
            xor ^= nums1[i];
        }
        for(int i = 0; i < nums2.length; i++) {
            xor ^= nums2[i];
        }
        return xor;
    }
    
    public int xorAllNums3(int[] nums1, int[] nums2) {
        int xor = 0;
        for(int i = 0; i < nums1.length; i++) {
            xor ^= nums1[i];
        }
        for(int i = 0; i < nums2.length; i++) {
            xor ^= nums2[i];
        }
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                xor ^= (nums1[i] ^ nums2[j]);
            }
        }
        return xor;
    }
    
    public int xorAllNums4(int[] nums1, int[] nums2) {
        int xor = 0;
        for(int i = 0; i < nums1.length; i++) {
            xor ^= nums1[i];
        }
        for(int i = 0; i < nums2.length; i++) {
            xor ^= nums2[i];
        }
        for(int i = 0; i < nums1.length; i++) {
            xor ^= nums1[i];
        }
        for(int i = 0; i < nums2.length; i++) {
            xor ^= nums2[i];
        }
        return xor;
    }
    
    public int xorAllNums5(int[] nums1, int[] nums2) {
        int xor = 0;
        for(int i = 0; i < nums1.length; i++) {
            xor ^= nums1[i];
        }
        for(int i = 0; i < nums2.length; i++) {
            xor ^= nums2[i];
    }
}