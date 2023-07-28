class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] result = new int[grid.length][grid[0].length];
        int[] rowDir = new int[]{-1, 0, 1, 0};
        int[] colDir = new int[]{0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = 1;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int rowPos = pos[0];
            int colPos = pos[1];
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int newRowPos = rowPos + rowDir[i];
                int newColPos = colPos + colDir[i];
                if (newRowPos < 0 || newRowPos >= grid.length || newColPos < 0 || newColPos >= grid[0].length) {
                    result[rowPos][colPos] = color;
                    continue;
                }
                if (grid[rowPos][colPos] != grid[newRowPos][newColPos]) {
                    result[rowPos][colPos] = color;
                }
                if (visited[newRowPos][newColPos] == 1 || grid[rowPos][colPos] != grid[newRowPos][newColPos]) {
                    count++;
                }
                if (visited[newRowPos][newColPos] == 0 && grid[rowPos][colPos] == grid[newRowPos][newColPos]) {
                    queue.add(new int[]{newRowPos, newColPos});
                    visited[newRowPos][newColPos] = 1;
                }
            }
            if (count == 4) {
                result[rowPos][colPos] = color;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (result[i][j] == 0) {
                    result[i][j] = grid[i][j];
                }
            }
        }
        return result;
    }
}