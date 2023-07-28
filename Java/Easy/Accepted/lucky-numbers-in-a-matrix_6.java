class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] min = new int[m];
        int[] max = new int[n];
        for (int i = 0; i < m; i++) {
            min[i] = matrix[i][0];
            for (int j = 1; j < n; j++) {
                min[i] = Math.min(min[i], matrix[i][j]);
            }
        }
        for (int j = 0; j < n; j++) {
            max[j] = matrix[0][j];
            for (int i = 1; i < m; i++) {
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == min[i] && matrix[i][j] == max[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }
}