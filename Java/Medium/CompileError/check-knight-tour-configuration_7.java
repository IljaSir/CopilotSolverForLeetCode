class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        int n = grid.length;
        int[][] moves = new int[][]{{-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};
        int x = 0, y = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n * n; i++) {
            if (grid[x][y] != i) {
                return false;
            }
            visited[x][y] = true;
            boolean found = false;
            for (int[] move : moves) {
                int nextX = x + move[0];
                int nextY = y + move[1];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                    x = nextX;
                    y = nextY;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
    }
}