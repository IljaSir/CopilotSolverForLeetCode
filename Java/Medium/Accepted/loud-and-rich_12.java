class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        int n = quiet.length;
        int[] ans = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] r : richer) {
            graph.get(r[1]).add(r[0]);
        }
        for (int i = 0; i < n; i++) {
            ans[i] = dfs(graph, quiet, new boolean[n], i);
        }
        return ans;
    }
    private int dfs(List<List<Integer>> graph, int[] quiet, boolean[] visited, int i) {
        if (visited[i]) {
            return i;
        }
        visited[i] = true;
        int min = i;
        for (int j : graph.get(i)) {
            int next = dfs(graph, quiet, visited, j);
            if (quiet[next] < quiet[min]) {
                min = next;
            }
        }
        return min;
    }
}