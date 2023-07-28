class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] tmp = new int[m][n];
        int[][] res = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                tmp[i][j] = grid[i][j];
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int newI = (i + (j + k) / n) % m;
                int newJ = (j + k) % n;
                res[newI][newJ] = tmp[i][j];
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i=0; i<m; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j=0; j<n; j++) {
                row.add(res[i][j]);
            }
            result.add(row);
        }
        return result;
    }
}