class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                res.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                res.add(nums1[i++]);
            } else {
                res.add(nums2[j++]);
            }
        }
        while (i < nums1.length) {
            res.add(nums1[i++]);
        }
        while (j < nums2.length) {
            res.add(nums2[j++]);
        }
        return res.toArray(new int[res.size()][]);
    }
}