class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        
        int[] deg = new int[n + 1];
        boolean[][] g = new boolean[n + 1][n + 1];
        for (int[] e : edges) {
            deg[e[0]]++;
            deg[e[1]]++;
            g[e[0]][e[1]] = true;
            g[e[1]][e[0]] = true;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i][j]) {
                    for (int k = 1; k <= n; k++) {
                        if (g[i][k] && g[j][k]) {
                            res = Math.min(res, deg[i] + deg[j] + deg[k] - 6);
                        }
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}