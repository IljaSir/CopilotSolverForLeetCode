class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        int i = 0, j = 0;
        int[][] res = new int[nums1.length + nums2.length][2];
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                res[k][0] = nums1[i][0];
                res[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                res[k][0] = nums1[i][0];
                res[k][1] = nums1[i][1];
                i++;
            } else {
                res[k][0] = nums2[j][0];
                res[k][1] = nums2[j][1];
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            res[k][0] = nums1[i][0];
            res[k][1] = nums1[i][1];
            i++;
            k++;
        }
        while (j < nums2.length) {
            res[k][0] = nums2[j][0];
            res[k][1] = nums2[j][1];
            j++;
            k++;
        }
        return Arrays.copyOf(res, k);
    }
}