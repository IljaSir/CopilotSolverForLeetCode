class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int[][] max = new int[4][n];
        int[][] min = new int[4][n];
        for (int i = 0; i < n; i++) {
            max[0][i] = arr1[i] + arr2[i] + i;
            min[0][i] = arr1[i] + arr2[i] + i;
            max[1][i] = arr1[i] + arr2[i] - i;
            min[1][i] = arr1[i] + arr2[i] - i;
            max[2][i] = arr1[i] - arr2[i] + i;
            min[2][i] = arr1[i] - arr2[i] + i;
            max[3][i] = arr1[i] - arr2[i] - i;
            min[3][i] = arr1[i] - arr2[i] - i;
        }
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int m = max[i][0];
            int mi = min[i][0];
            for (int j = 1; j < n; j++) {
                res = Math.max(res, Math.max(m - min[i][j], max[i][j] - mi));
                m = Math.max(m, max[i][j]);
                mi = Math.min(mi, min[i][j]);
            }
        }
        return res;
    }
}