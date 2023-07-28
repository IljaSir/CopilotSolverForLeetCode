class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> luckyNumbers = new ArrayList<>();
        int[] rowMin = new int[matrix.length];
        int[] colMax = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            rowMin[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            colMax[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }
        return luckyNumbers;
    }
}