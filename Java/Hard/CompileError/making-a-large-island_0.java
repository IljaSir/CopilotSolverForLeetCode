class Solution {
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        int[] parent = new int[n * n];
        int[] area = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            area[i] = 1;
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                int p = i * n + j;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                    int q = x * n + y;
                    union(parent, area, p, q);
                }
            }
        }
        int maxArea = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int[] count = new int[n * n];
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                        int p = x * n + y;
                        int rootP = find(parent, p);
                        if (count[rootP] == 0) {
                            count[rootP] = area[rootP];
                        }
                    }
                    int curArea = 1;
                    for (int c : count) {
                        curArea += c;
                    }
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }
}