class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            for (; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    break;
                }
            }
            for (; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
            if (j == nums2.length) {
                result[i] = -1;
            }
        }
        return result;
    }
}