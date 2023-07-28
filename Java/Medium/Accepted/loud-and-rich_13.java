class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        int n = quiet.length;
        List<Integer>[] graph = new ArrayList[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] r : richer) {
            graph[r[1]].add(r[0]);
        }
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            dfs(graph, ans, quiet, i);
        }
        return ans;
    }
    private int dfs(List<Integer>[] graph, int[] ans, int[] quiet, int i) {
        if (ans[i] == -1) {
            ans[i] = i;
            for (int j : graph[i]) {
                int q = dfs(graph, ans, quiet, j);
                if (quiet[q] < quiet[ans[i]]) {
                    ans[i] = q;
                }
            }
        }
        return ans[i];
    }
}