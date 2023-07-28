class Solution {
    public int[] findBall(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int c = i;
            for (int j = 0; j < m; j++) {
                if (grid[j][c] == 1 && c < n - 1 && grid[j][c + 1] == 1) {
                    c++;
                } else if (grid[j][c] == -1 && c > 0 && grid[j][c - 1] == -1) {
                    c--;
                } else {
                    c = -1;
                    break;
                }
            }
            result[i] = c;
        }
        return result;
    }
}