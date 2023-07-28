class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        int[] minRow = new int[matrix.length];
        int[] maxCol = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            minRow[i] = min;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int max = matrix[0][i];
            for (int j = 1; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            maxCol[i] = max;
        }
        for (int i = 0; i < minRow.length; i++) {
            for (int j = 0; j < maxCol.length; j++) {
                if (minRow[i] == maxCol[j]) {
                    result.add(minRow[i]);
                }
            }
        }
        return result;
    }
}