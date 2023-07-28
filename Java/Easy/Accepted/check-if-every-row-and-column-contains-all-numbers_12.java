class Solution {
    public boolean checkValid(int[][] matrix) {
        
        int n = matrix.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            if (!rowSet.equals(set) || !colSet.equals(set)) {
                return false;
            }
        }
        return true;
    }
}