class Solution {
    public boolean hasValidPath(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            if (grid[x][y] == '(') {
                if (y + 1 < n && !visited[x][y + 1] && (grid[x][y + 1] == '(' || grid[x][y + 1] == '*')) {
                    queue.add(new int[]{x, y + 1});
                    visited[x][y + 1] = true;
                }
                if (x + 1 < m && !visited[x + 1][y] && (grid[x + 1][y] == '/' || grid[x + 1][y] == '*')) {
                    queue.add(new int[]{x + 1, y});
                    visited[x + 1][y] = true;
                }
            } else if (grid[x][y] == ')') {
                if (y - 1 >= 0 && !visited[x][y - 1] && (grid[x][y - 1] == ')' || grid[x][y - 1] == '*')) {
                    queue.add(new int[]{x, y - 1});
                    visited[x][y - 1] = true;
                }
                if (x - 1 >= 0 && !visited[x - 1][y] && (grid[x - 1][y] == '/' || grid[x - 1][y] == '*')) {
                    queue.add(new int[]{x - 1, y});
                    visited[x - 1][y] = true;
                }
            } else if (grid[x][y] == '*') {
                if (y + 1 < n && !visited[x][y + 1] && (grid[x][y + 1] == '(' || grid[x][y + 1] == '*')) {
                    queue.add(new int[]{x, y + 1});
                    visited[x
    }
}