class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] temp = new int[m*n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[index++] = grid[i][j];
            }
        }
        k = k % (m*n);
        for (int i = 0; i < k; i++) {
            int last = temp[m*n-1];
            for (int j = m*n-1; j > 0; j--) {
                temp[j] = temp[j-1];
            }
            temp[0] = last;
        }
        List<List<Integer>> result = new ArrayList<>();
        index = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(temp[index++]);
            }
            result.add(row);
        }
        return result;
    }
}