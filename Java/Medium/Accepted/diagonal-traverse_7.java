class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int i = 0;
        int j = 0;
        boolean up = true;
        for (int k = 0; k < m * n; k++) {
            ans[k] = mat[i][j];
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
        return ans;
    }
}