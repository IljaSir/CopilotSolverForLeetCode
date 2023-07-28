class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int m = mat.length, n = mat[0].length;
        int left = 0, right = m - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int maxCol = 0;
            for (int j = 1; j < n; ++j) {
                if (mat[mid][j] > mat[mid][maxCol]) {
                    maxCol = j;
                }
            }
            if (mat[mid][maxCol] > mat[mid + 1][maxCol]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int maxCol = 0;
        for (int j = 1; j < n; ++j) {
            if (mat[left][j] > mat[left][maxCol]) {
                maxCol = j;
            }
        }
        return new int[]{left, maxCol};
    }
}