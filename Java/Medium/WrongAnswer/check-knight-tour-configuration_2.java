class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        int[][] moves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        int n = grid.length;
        int[] pos = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        int[] newPos = new int[2];
        for (int i = 1; i < n * n; i++) {
            boolean valid = false;
            for (int[] move : moves) {
                newPos[0] = pos[0] + move[0];
                newPos[1] = pos[1] + move[1];
                if (newPos[0] >= 0 && newPos[0] < n && newPos[1] >= 0 && newPos[1] < n && grid[newPos[0]][newPos[1]] == i) {
                    valid = true;
                    pos[0] = newPos[0];
                    pos[1] = newPos[1];
                    break;
                }
            }
            if (!valid) {
                return false;
            }
        }
        return true;
    }
}