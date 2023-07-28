class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowMin = new int[m];
        int[] colMax = new int[n];
        for (int i = 0; i < m; i++) {
            rowMin[i] = matrix[i][0];
            for (int j = 1; j < n; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            colMax[i] = matrix[0][i];
            for (int j = 1; j < m; j++) {
                colMax[i] = Math.max(colMax[i], matrix[j][i]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowMin[i] == colMax[j]) {
                    res.add(rowMin[i]);
                }
            }
        }
        return res;
    }
}