class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
    public int[] smallestCommonElement(int[][] mat) {
        int[] res = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            res[i] = getCommon(mat[0], mat[i]);
        }
        return res;
    }
}