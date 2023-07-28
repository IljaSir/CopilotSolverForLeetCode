class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        int n = mat.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = mat[i][j];
            }
        }
        if (Arrays.deepEquals(rotated, target)) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = mat[i][j];
            }
        }
        if (Arrays.deepEquals(rotated, target)) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = mat[i][j];
            }
        }
        if (Arrays.deepEquals(rotated, target)) {
            return true;
        }
        return false;
    }
}