class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        
        int[][] matrix = new int[m][n];
        for (int[] index : indices) {
            for (int i = 0; i < m; i++) {
                matrix[i][index[1]]++;
            }
            for (int j = 0; j < n; j++) {
                matrix[index[0]][j]++;
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}