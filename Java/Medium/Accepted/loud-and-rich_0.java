class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        int n = quiet.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : richer) {
            graph[edge[1]].add(edge[0]);
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            dfs(graph, quiet, res, i);
        }
        return res;
    }
    private int dfs(List<Integer>[] graph, int[] quiet, int[] res, int i) {
        if (res[i] >= 0) {
            return res[i];
        }
        res[i] = i;
        for (int j : graph[i]) {
            if (quiet[res[i]] > quiet[dfs(graph, quiet, res, j)]) {
                res[i] = res[j];
            }
        }
        return res[i];
    }
}