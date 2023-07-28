class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        
        int[][] res = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (k < original.length) {
                    res[i][j] = original[k];
                    k++;
                } else {
                    return new int[0][0];
                }
            }
        }
        if (k < original.length) {
            return new int[0][0];
        }
        return res;
    }
}