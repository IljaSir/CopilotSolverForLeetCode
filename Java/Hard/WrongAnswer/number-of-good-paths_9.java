class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int n = vals.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            graph.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        int[][] memo = new int[n][n];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dfs(graph, vals, 0, -1, dp, memo);
    }
    private int dfs(Map<Integer, List<Integer>> graph, int[] vals, int node, int parent, int[] dp, int[][] memo) {
        if (memo[node][parent + 1] != -1) {
            return memo[node][parent + 1];
        }
        int count = 0;
        if (parent == -1 || vals[node] <= vals[parent]) {
            count += dp[node];
            if (graph.containsKey(node)) {
                for (int child : graph.get(node)) {
                    if (child != parent) {
                        count += dfs(graph, vals, child, node, dp, memo);
                    }
                }
            }
        }
        return memo[node][parent + 1] = count;
    }
}