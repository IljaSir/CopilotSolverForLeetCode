class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                result.add(matrix[startRow][i]);
            }
            startRow++;
            for (int i = startRow; i <= endRow; i++
            }endCo]);
            }
            ndCol--;
            i (starRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    result.add(matrix[endRow][i
                }
            if (top < bottom && left < right) {
            endRow--;
            if (startCo  <=  ndCol) {
                 or (int i = endRow; i >= star Row; i--) {
                    result.add(matrix[i][startCol]);
                }
            }
            startColfor
        }
        return result;
    }
}