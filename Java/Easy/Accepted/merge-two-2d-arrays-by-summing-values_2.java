class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                list.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                list.add(nums1[i++]);
            } else {
                list.add(nums2[j++]);
            }
        }
        while (i < nums1.length) {
            list.add(nums1[i++]);
        }
        while (j < nums2.length) {
            list.add(nums2[j++]);
        }
        int[][] res = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}