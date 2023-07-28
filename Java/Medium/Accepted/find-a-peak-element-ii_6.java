class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int row = mat.length;
        int col = mat[0].length;
        int l = 0;
        int r = col - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int maxRow = 0;
            for (int i = 0; i < row; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }
            if (mat[maxRow][mid] < mat[maxRow][mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int maxRow = 0;
        for (int i = 0; i < row; i++) {
            if (mat[i][l] > mat[maxRow][l]) {
                maxRow = i;
            }
        }
        return new int[]{maxRow, l};
    }
}