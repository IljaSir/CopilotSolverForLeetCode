class Solution {
    public int checkWays(int[][] pairs) {
        
        int n = 500;
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] pair : pairs) {
            int x = pair[0], y = pair[1];
            int px = find(parent, x);
            int py = find(parent, y);
            if (px != py) {
                parent[px] = py;
                size[py] += size[px];
            }
        }
        int[] degree = new int[n + 1];
        for (int[] pair : pairs) {
            int x = pair[0], y = pair[1];
            int px = find(parent, x);
            int py = find(parent, y);
            if (px != py) {
                degree[px]++;
                degree[py]++;
            }
        }
        int[] roots = new int[n + 1];
        int rootCount = 0;
        for (int i = 1; i <= n; i++) {
            if (parent[i] == i) {
                roots[rootCount++] = i;
            }
        }
        if (rootCount > 1) {
            return 2;
        }
        int root = roots[0];
        if (degree[root] != size[root] - 1) {
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            if (parent[i] != root && degree[i] != 1) {
                return 0;
            }
        }
        return 1;
    }
}