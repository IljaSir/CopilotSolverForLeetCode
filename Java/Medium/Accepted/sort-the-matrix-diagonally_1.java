class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            sort(mat, i, 0);
        }
        for (int j = 1; j < n; j++) {
            sort(mat, 0, j);
        }
        return mat;
    }
    
    private void sort(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;
        int[] temp = new int[Math.min(m - i, n - j)];
        int k = 0;
        while (i < m && j < n) {
            temp[k++] = mat[i++][j++];
        }
        Arrays.sort(temp);
        i--;
        j--;
        while (i >= 0 && j >= 0) {
            mat[i--][j--] = temp[--k];
        }
    }
}