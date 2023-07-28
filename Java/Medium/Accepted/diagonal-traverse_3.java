class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int i = 0;
        int j = 0;
        int k = 0;
        boolean up = true;
        while (i < m && j < n) {
            result[k++] = mat[i][j];
            if (up) {
                if (i == 0) {
                    up = false;
                    if (j == n - 1) {
                        i++;
                    } else {
                        j++;
                    }
                } else if (j == n - 1) {
                    up = false;
                    i++;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (j == 0) {
                    up = true;
                    if (i == m - 1) {
                        j++;
                    } else {
                        i++;
                    }
                } else if (i == m - 1) {
                    up = true;
                    j++;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }
}