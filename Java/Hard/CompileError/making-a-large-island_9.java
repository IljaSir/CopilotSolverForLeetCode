class Solution {
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        int[] parent = new int[n*n+2];
        int[] size = new int[n*n+2];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < n*n+2; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                int p = i*n+j+1;
                for (int k = 0; k < 4; k++) {
                    int x = i+dx[k];
                    int y = j+dy[k];
                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                        int q = x*n+y+1;
                        int pRoot = find(parent, p);
                        int qRoot = find(parent, q);
                        if (pRoot != qRoot) {
                            parent[qRoot] = pRoot;
                            size[pRoot] += size[qRoot];
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                int p = i*n+j+1;
                int pRoot = find(parent, p);
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int x = i+dx[k];
                    int y = j+dy[k];
                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                        int q = x*n+y+1;
                        int qRoot = find(parent, q);
                        if (!set.contains(qRoot)) {
                            set.add(qRoot);
                            res = Math.max(res, size[qRoot]);
                        }
                    }
                }
    }
}