class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i][0] == nums2[j][0]) {
                    result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                    i++;
                    j++;
                } else if (nums1[i][0] < nums2[j][0]) {
                    result.add(new int[]{nums1[i][0], nums1[i][1]});
                    i++;
                } else {
                    result.add(new int[]{nums2[j][0], nums2[j][1]});
                    j++;
                }
            } else if (i < nums1.length) {
                result.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            } else {
                result.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}