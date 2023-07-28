class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        int[] rowMin = new int[m];
        int[] colMin = new int[n];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMin, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                rowMax[i] = Math.max(rowMax[i], val);
                colMax[j] = Math.max(colMax[j], val);
                rowMin[i] = Math.min(rowMin[i], val);
                colMin[j] = Math.min(colMin[j], val);
            }
        }
        int[] rowRank = new int[m];
        int[] colRank = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (rowMax[i] == val || colMax[j] == val) {
                    res[i][j] = Math.max(rowRank[i], colRank[j]) + 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (rowMin[i] == val || colMin[j] == val) {
                    res[i][j] = Math.max(rowRank[i], colRank[j]) + 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (res[i][j] == 0) {
                    res[i][j] = Math.max(rowRank[i], colRank[j]) + 1;
                }
                rowRank[i] = Math.max(rowRank[i], res[i][j]);
                colRank[j] = Math.max(colRank[j], res[i][j]);
            }
        }
        return res
    }
}