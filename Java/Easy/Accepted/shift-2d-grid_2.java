class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] newGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = (i * n + j + k) % (m * n);
                int newI = a / n;
                int newJ = a % n;
                newGrid[newI][newJ] = grid[i][j];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(newGrid[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }
}