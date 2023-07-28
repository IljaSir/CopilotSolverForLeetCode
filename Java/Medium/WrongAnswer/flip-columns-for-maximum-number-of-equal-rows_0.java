class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            int count = 1;
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][0] == matrix[j][0]) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        if (matrix[i][k] != matrix[j][k]) {
                            count = 0;
                            break;
                        }
                    }
                } else {
                    for (int k = 0; k < matrix[0].length; k++) {
                        if (matrix[i][k] == matrix[j][k]) {
                            count = 0;
                            break;
                        }
                    }
                }
                if (count == 1) {
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}