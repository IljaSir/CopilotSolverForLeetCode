class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = mat;
        for (int i = 0; i < m; i++) {
            int[] temp = new int[Math.min(m - i, n)];
            int k = 0;
            for (int j = 0; j < Math.min(m - i, n); j++) {
                temp[k++] = mat[i + j][j];
            }
            Arrays.sort(temp);
            k = 0;
            for (int j = 0; j < Math.min(m - i, n); j++) {
                res[i + j][j] = temp[k++];
            }
        }
        for (int j = 1; j < n; j++) {
            int[] temp = new int[Math.min(m, n - j)];
            int k = 0;
            for (int i = 0; i < Math.min(m, n - j); i++) {
                temp[k++] = mat[i][j + i];
            }
            Arrays.sort(temp);
            k = 0;
            for (int i = 0; i < Math.min(m, n - j); i++) {
                res[i][j + i] = temp[k++];
            }
        }
        return res;
    }
}