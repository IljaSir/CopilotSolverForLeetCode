class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        int i = 0, j = 0;
        int[][] res = new int[nums1.length + nums2.length][2];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] < nums2[j][0]) {
                res[i + j] = nums1[i];
                i++;
            } else if (nums1[i][0] > nums2[j][0]) {
                res[i + j] = nums2[j];
                j++;
            } else {
                res[i + j] = new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]};
                i++;
                j++;
            }
        }
        while (i < nums1.length) {
            res[i + j] = nums1[i];
            i++;
        }
        while (j < nums2.length) {
            res[i + j] = nums2[j];
            j++;
        }
        return Arrays.copyOf(res, i + j);
    }
}