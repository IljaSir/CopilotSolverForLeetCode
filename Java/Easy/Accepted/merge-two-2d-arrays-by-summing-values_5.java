class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < m && j < n) {
            int[] a = nums1[i];
            int[] b = nums2[j];
            if (a[0] == b[0]) {
                res.add(new int[]{a[0], a[1] + b[1]});
                i++;
                j++;
            } else if (a[0] < b[0]) {
                res.add(a);
                i++;
            } else {
                res.add(b);
                j++;
            }
        }
        while (i < m) {
            res.add(nums1[i]);
            i++;
        }
        while (j < n) {
            res.add(nums2[j]);
            j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}