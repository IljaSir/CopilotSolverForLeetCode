class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int[][] result = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i - 1 >= 0) {
                    result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                }
            }
        }
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (i + 1 < mat.length) {
                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                }
                if (j + 1 < mat[0].length) {
                    result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                }
            }
        }
        return result;
    }
}