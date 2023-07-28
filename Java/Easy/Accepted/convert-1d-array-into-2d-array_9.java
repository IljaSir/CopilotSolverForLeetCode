class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        
        int[][] result = new int[m][n];
        int i = 0;
        int j = 0;
        int k = 0;
        if (original.length != m * n) {
            return new int[0][0];
        }
        while (k < original.length) {
            if (i < m && j < n) {
                result[i][j] = original[k];
                j++;
                k++;
            } else if (i < m && j == n) {
                i++;
                j = 0;
            }
        }
        return result;
    }
}