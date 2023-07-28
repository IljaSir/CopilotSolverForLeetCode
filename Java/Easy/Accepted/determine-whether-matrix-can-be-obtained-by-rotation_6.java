class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        int n = mat.length;
        boolean isSame = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            mat = rotate(mat);
            isSame = true;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (mat[j][k] != target[j][k]) {
                        isSame = false;
                        break;
                    }
                }
            }
            if (isSame) {
                return true;
            }
        }
        return false;
    }

    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] newMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMat[j][n - 1 - i] = mat[i][j];
            }
        }
        return newMat;
    }
}