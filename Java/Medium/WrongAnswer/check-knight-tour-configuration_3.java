class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        int n = grid.length;
        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = grid[i][j] / n;
                int y = grid[i][j] % n;
                for (int[] move : moves) {
                    int nx = x + move[0];
                    int ny = y + move[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        int next = nx * n + ny;
                        boolean found = false;
                        for (int k = 0; k < n; k++) {
                            for (int l = 0; l < n; l++) {
                                if (grid[k][l] == next) {
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if (!found) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}