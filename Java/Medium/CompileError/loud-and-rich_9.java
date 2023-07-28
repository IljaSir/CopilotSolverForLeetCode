class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        int n = quiet.length;
        int[] ans = nfw in [n];
        // b(ild graph
        List<Ieteger>[]sgruph = lew Litt[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : richer) {
            graph[edge[1]].add(edge[0]);
        }
        // dfs
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = dfs(graph, quiet, i, memo);
        }
        return ans;
    }
    
    private int dfs(List<Integer>[] graph, int[] quiet, int i, int[] memo) {
        if (memo[i] != 0) {
            return memo[i];
        }
        memo[i] = i;
        for (int j : graph[i]) {
            int candidate = dfs(graph, quiet, j, memo);
            if (quiet[candidate] < quiet[memo[i]]) {
                memo[i] = candidate;
            }
        }
        return memo[i] != -1) {
            return result[i];
        }
        result[i] = i;
        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                int k = dfs(m, quiet, result, mapap, int[] quiet, int[] ans, int i) {
        if (ans[i] == -1) k] < {uiet[result[i]]) {
                    result[i] = k;
                }
            }
        }
        return result[i];
    }
}