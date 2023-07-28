class Solution {
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        int[] parent = new int[n*n];
        int[] size = new int[n*n];
        int[] dir = new int[]{0, 1, 0, -1, 0};
        for (int i = 0; i < n*n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dir[k];
                        int y = j + dir[k+1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                            union(parent, size, i*n+j, x*n+y);
                        }
                    }
                    max = Math.max(max, size[find(parent, i*n+j)]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int x = i + dir[k];
                        int y = j + dir[k+1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                            set.add(find(parent, x*n+y));
                        }
                    }
                    int sum = 1;
                    for (int p : set) {
                        sum += size[p];
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}