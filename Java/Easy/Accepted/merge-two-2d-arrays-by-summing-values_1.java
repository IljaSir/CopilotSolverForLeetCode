class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        int[][] result = new int[nums1.length + nums2.length][2];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] < nums2[j][0]) {
                result[k][0] = nums1[i][0];
                result[k][1] = nums1[i][1];
                i++;
            } else if (nums1[i][0] > nums2[j][0]) {
                result[k][0] = nums2[j][0];
                result[k][1] = nums2[j][1];
                j++;
            } else {
                result[k][0] = nums1[i][0];
                result[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            result[k][0] = nums1[i][0];
            result[k][1] = nums1[i][1];
            i++;
            k++;
        }
        while (j < nums2.length) {
            result[k][0] = nums2[j][0];
            result[k][1] = nums2[j][1];
            j++;
            k++;
        }
        int[][] finalResult = new int[k][2];
        for (int l = 0; l < k; l++) {
            finalResult[l][0] = result[l][0];
            finalResult[l][1] = result[l][1];
        }
        return finalResult;
    }
}