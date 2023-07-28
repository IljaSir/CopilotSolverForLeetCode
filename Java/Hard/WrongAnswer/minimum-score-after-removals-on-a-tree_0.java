class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[][] g = new int[n][n];
        for (int[] e : edges) {
            g[e[0]][e[1]] = g[e[1]][e[0]] = 1;
        }
        int[] xor = new int[n];
        for (int i = 0; i < n; i++) {
            xor[i] = nums[i];
        }
        int[] min = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        int[] max = new int[n];
        dfs(0, -1, g, xor, min, max);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (g[i][j] == 1) {
                    res = Math.min(res, Math.min(min[i] ^ max[j], min[j] ^ max[i]));
                }
            }
        }
        return res;
    }
    
    void dfs(int u, int p, int[][] g, int[] xor, int[] min, int[] max) {
        for (int v = 0; v < g.length; v++) {
            if (v != p && g[u][v] == 1) {
                dfs(v, u, g, xor, min, max);
                xor[u] ^= xor[v];
            }
        }
        min[u] = Math.min(min[u], xor[u]);
        max[u] = Math.max(max[u], xor[u]);
    }
}