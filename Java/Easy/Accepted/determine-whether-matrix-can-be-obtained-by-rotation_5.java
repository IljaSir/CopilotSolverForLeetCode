class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        int n = mat.length;
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) return true;
            int[][] tmp = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    tmp[j][k] = mat[n - k - 1][j];
                }
            }
            mat = tmp;
        }
        return false;
    }
}