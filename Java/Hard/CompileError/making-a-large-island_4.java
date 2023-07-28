class Solution {
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        int[] parent = new int[n*n+1];
        int[] size = new int[n*n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int id = i*n+j+1;
                    parent[id] = id;
                    size[id] = 1;
                }
            }
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int p1 = find(parent, i*n+j+1);
                    for (int[] d : dirs) {
                        int x = i+d[0];
                        int y = j+d[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                            int p2 = find(parent, x*n+y+1);
                            if (p1 != p2) {
                                parent[p2] = p1;
                                size[p1] += size[p2];
                            }
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n*n; i++) {
            if (size[i] > max) {
                max = size[i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int[] p = new int[4];
                    int cnt = 0;
                    for (int[] d : dirs) {
                        int x = i+d[0];
                        int y = j+d[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                            int p1 = find(parent, x*n+y+1);
                            if (cnt == 0 || p1 != p[0
    }
}