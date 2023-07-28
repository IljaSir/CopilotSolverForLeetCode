class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        int n = mat.length;
        int m = mat[0].length;
        int[][] rotated = new int[n][m];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    rotated[j][k] = mat[n - 1 - k][j];
                }
            }
            if (Arrays.deepEquals(rotated, target)) {
                return true;
            }
            mat = rotated;
            rotated = new int[n][m];
        }
        return false;
    }
}