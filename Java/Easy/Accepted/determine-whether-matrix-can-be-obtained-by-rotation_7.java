class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        int n = mat.length;
        if (n != target.length || n != target[0].length) return false;
        if (n == 1) return mat[0][0] == target[0][0];
        
        for (int i = 0; i < 4; i++) {
            rotate(mat, n);
            if (Arrays.deepEquals(mat, target)) return true;
        }
        return false;
    }
    
    private void rotate(int[][] mat, int n) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[n - j - 1][i];
                mat[n - j - 1][i] = mat[n - i - 1][n - j - 1];
                mat[n - i - 1][n - j - 1] = mat[j][n - i - 1];
                mat[j][n - i - 1] = temp;
            }
        }
    }
}