class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        int[] dp = new int[n];
        int[] visited = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                res = Math.max(res, dfs(edges, visited, dp, i));
            }
        }
        return res;
    }
    private int dfs(int[] edges, int[] visited, int[] dp, int i) {
        if (visited[i] == 1) {
            return 0;
        }
        if (visited[i] == 2) {
            return dp[i];
        }
        visited[i] = 2;
        int next = edges[i];
        if (next == -1) {
            dp[i] = 0;
        } else {
            dp[i] = dfs(edges, visited, dp, next) + 1;
        }
        visited[i] = 1;
        return dp[i];
    }
}