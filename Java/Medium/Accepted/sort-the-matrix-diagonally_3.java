class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int x = i;
            int y = 0;
            int[] tmp = new int[Math.min(m - x, n - y)];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = mat[x + j][y + j];
            }
            Arrays.sort(tmp);
            for (int j = 0; j < tmp.length; j++) {
                mat[x + j][y + j] = tmp[j];
            }
        }
        for (int i = 1; i < n; i++) {
            int x = 0;
            int y = i;
            int[] tmp = new int[Math.min(m - x, n - y)];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = mat[x + j][y + j];
            }
            Arrays.sort(tmp);
            for (int j = 0; j < tmp.length; j++) {
                mat[x + j][y + j] = tmp[j];
            }
        }
        return mat;
    }
}