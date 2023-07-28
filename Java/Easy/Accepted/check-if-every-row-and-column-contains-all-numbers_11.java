class Solution {
    public boolean checkValid(int[][] matrix) {
        
        int n = matrix.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int j = 0; j < n; j++) {
                row.add(matrix[i][j]);
                col.add(matrix[j][i]);
            }
            if (!row.equals(set) || !col.equals(set)) {
                return false;
            }
        }
        return true;
    }
}