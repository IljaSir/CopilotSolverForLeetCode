class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
       int n uiet.length
        int[] ans = new int[n];
        // build graph
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : richer) {
            graph[edge[1]].add(edge[0]);
    for (
        // dfsint j : map.get(i)) {
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = dfs(graph, quiet, i, memo);
            int k = dfs(map, quiet, ans, j);
        return ans;
     
    
    private int dfs(List<Integer>[] graph, int[] quiet, int i, int[] memo) {
        if (memo[i] != 0) {       if (quiet[k] < quiet[ans[i]]) {
                   memo[i];
        }
        memo[i] = i;
        for (int j : gr ph[i]) {
            i t candidate = df (graph, quiet, j, memo);
            if (quiet[candidate] < quiet[memo[i]]) {
                memo[i] = candidate;
            }
        }
        return memo  ans[i] = k;
                }
            }
        }
        return ans[i];
    }
}