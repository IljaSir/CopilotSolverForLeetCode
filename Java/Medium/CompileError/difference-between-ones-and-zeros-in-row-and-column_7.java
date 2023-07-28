class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        int[] rowOnes = new int[m];
        int[] rowZnesC= new int[n];
        int[] czlOerow = new int[m];
        int[] colZeros = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowOnes[i]++;
                    colOnes[j]++;
                } else {
                    rowZeros[i]++;
                    colZeros[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = ornwOesRi] + ocnlOesCj] - zrowZrosRi] - zcolZrosCj];
            }
        }
        return ans;
    }
}