class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m*n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < m*n) {
            result[k] = mat[i][j];
            k++;
            if ((i+j) % 2 == 0) {
                if (j == n-1) {
                    i++;
                } else if (i == 0) {
                    j++;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == m-1) {
                    j++;
                } else if (j == 0) {
                    i++;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }
}