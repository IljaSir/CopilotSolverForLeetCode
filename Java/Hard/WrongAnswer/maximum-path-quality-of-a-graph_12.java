class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }
        int n = values.length;
        int[] dp = new int[n];
        dp[0] = values[0];
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(0, map, dp, visited, values, maxTime);
        return dp[0];
    }
    
    private int dfs(int u, Map<Integer, List<int[]>> map, int[] dp, boolean[] visited, int[] values, int maxTime) {
        int res = 0;
        for (int[] edge : map.getOrDefault(u, new ArrayList<>())) {
            int v = edge[0];
            int time = edge[1];
            if (visited[v]) continue;
            visited[v] = true;
            int sub = dfs(v, map, dp, visited, values, maxTime - time);
            if (sub >= 0) {
                res = Math.max(res, sub + values[v]);
            }
            visited[v] = false;
        }
        dp[u] = res;
        return res;
    }
}