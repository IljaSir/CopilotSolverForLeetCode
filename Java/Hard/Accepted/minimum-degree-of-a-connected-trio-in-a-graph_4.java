class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        
        int[] degree = new int[n + 1];
        boolean[][] edge = new boolean[n + 1][n + 1];
        for (int[] e : edges) {
            degree[e[0]]++;
            degree[e[1]]++;
            edge[e[0]][e[1]] = true;
            edge[e[1]][e[0]] = true;
        }
        int ans = Integer.MAX_VALUE;
        for (int[] e : edges) {
            for (int i = 1; i <= n; i++) {
                if (edge[e[0]][i] && edge[e[1]][i]) {
                    ans = Math.min(ans, degree[e[0]] + degree[e[1]] + degree[i] - 6);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}