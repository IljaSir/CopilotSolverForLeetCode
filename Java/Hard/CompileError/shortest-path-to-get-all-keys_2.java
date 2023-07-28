class Solution {
    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length;
        int n = grid[0].length();
        int[] start = new int[2];
        int keyCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    start[0] = i;
                    start[1] = j;
                }
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    keyCount++;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][][] visited = new boolean[m][n][64];
        visited[start[0]][start[1]][0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                int keys = curr[2];
                if (keys == (1 << keyCount) - 1) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX].charAt(newY) == '#') {
                        continue;
                    }
                    int newKeys = keys;
                    if (grid[newX].charAt(newY) >= 'a' && grid[newX].charAt(newY) <= 'f') {
                        newKeys |= (1 << (grid[newX].charAt(newY) - 'a'));
                    }
                    if (grid[newX].charAt(newY) >= 'A' && grid[newX].charAt(newY) <= 'F' && ((newKeys >> (grid[newX].charAt(newY) - 'A')) & 1) == 0) {
                        continue;
                    }
    }
}