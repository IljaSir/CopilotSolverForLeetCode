class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int[][] result = new int[mat.length][mat[0].length];
        int[][] visited = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = 1;
                }
            }
        }
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dir[i][0];
                int y = cur[1] + dir[i][1];
                if (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && visited[x][y] == 0) {
                    result[x][y] = result[cur[0]][cur[1]] + 1;
                    visited[x][y] = 1;
                    queue.add(new int[] {x, y});
                }
            }
        }
        return result;
    }
}