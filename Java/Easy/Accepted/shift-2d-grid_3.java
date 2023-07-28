class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[(i + (j + k) / n) % m][(j + k) % n] = grid[i][j];
            }
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>(m);
        for (int i = 0; i < m; i++) {
            ans.add(new ArrayList<Integer>(n));
            for (int j = 0; j < n; j++) {
                ans.get(i).add(res[i][j]);
            }
        }
        return ans;
    }
}