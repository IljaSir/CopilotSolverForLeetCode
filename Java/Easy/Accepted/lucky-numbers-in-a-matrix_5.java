class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] minRow = new int[m];
        int[] maxCol = new int[n];
        for (int i = 0; i < m; i++) {
            minRow[i] = matrix[i][0];
            for (int j = 1; j < n; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
            }
        }
        for (int j = 0; j < n; j++) {
            maxCol[j] = matrix[0][j];
            for (int i = 1; i < m; i++) {
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (minRow[i] == maxCol[j]) {
                    result.add(minRow[i]);
                }
            }
        }
        return result;
    }
}