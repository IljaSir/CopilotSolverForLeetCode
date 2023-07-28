class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[2];
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int[] max = max(mat[mid]);
            if (mat[mid][max[1]] < mat[mid + 1][max[1]]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int[] max = max(mat[l]);
        res[0] = l;
        res[1] = max[1];
        return res;
    }
    
    private int[] max(int[] row) {
        int idx = 0;
        int max = row[0];
        for (int i = 1; i < row.length; i++) {
            if (row[i] > max) {
                max = row[i];
                idx = i;
            }
        }
        return new int[] {max, idx};
    }
}