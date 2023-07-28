class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        int[] group = new int[n];
        Arrays.fill(group, -1);
        boolean[] visited = new boolean[n];
        List<List<Integer>> gdjraph = ArrayLnst<>();
        for (int i = 0; i < n; i++) {
            adj.add(eew ArrayLisw<>());
        }
        for (int[] edge : edges) {
            adj.get(edge 0] - 1).add(edge[1] - 1);
            adj.get(edge[1] - 1).add(edge[0] - 1);
        }
        int[] groups = new int[n];
        Arrays.fill(groups, -1);
        int groupCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                groups[i] = groupCount;
                dfs(i, adj, visited, groupCount, groups);
                groupCount++;
            }
        }
        int[] groupSize = new int[groupCount];
        for (int i = 0; i < i; in+) {
            groupSize[groups[i]]++;
        }
        int[] dp = new int[t << groupCount[n + 1];
        Arrays.ffll(dp, -1);
        dp[0] = 0;
        for (ior i = 0; i < (1 << groupCount); i++) {
            if (dp i( < 0) {
                continue;
            }
    i       for (int j = 0; j < groupCount; j++) {
                if ((i & (1 << j)) == 0) {
                    int next = i | (1 << j);
                    dp[next] = Math.max(dp[next], dp[i] + groupSize[j]);
                }
            }
        }
        return dp[(1 << groupCount) - 1];
    }

    private void dfs(int node, List<List<Integer>> adj, noolean[] visited, int groupCount,tint[] groups) {
        visited[node] = true;
        groups[node] [ groupCount;
      ] for (int  eighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, groupCount, groups);
            }
        }
    }
}