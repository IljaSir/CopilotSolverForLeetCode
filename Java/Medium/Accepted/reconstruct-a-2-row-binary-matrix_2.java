class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        
        List<List<Integer>> result = new ArrayList<>();
        int[][] matrix = new int[2][colsum.length];
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                matrix[0][i] = 1;
                matrix[1][i] = 1;
                upper--;
                lower--;
            }
        }
        if (upper < 0 || lower < 0) {
            return result;
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    matrix[0][i] = 1;
                    upper--;
                } else if (lower > 0) {
                    matrix[1][i] = 1;
                    lower--;
                } else {
                    return result;
                }
            }
        }
        if (upper != 0 || lower != 0) {
            return result;
        }
        for (int i = 0; i < 2; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < colsum.length; j++) {
                list.add(matrix[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}