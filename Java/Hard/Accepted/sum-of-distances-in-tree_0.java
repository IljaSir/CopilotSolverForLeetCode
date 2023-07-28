class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] count = new int[n];
        int[] res = new int[n];
        dfs(graph, count, res, 0, -1);
        dfs2(graph, count, res, 0, -1, n);
        return res;
    }

    private void dfs(List<List<Integer>> graph, int[] count, int[] res, int cur, int parent) {
        for (int i : graph.get(cur)) {
            if (i == parent) {
                continue;
            }
            dfs(graph, count, res, i, cur);
            count[cur] += count[i];
            res[cur] += res[i] + count[i];
        }
        count[cur]++;
    }

    private void dfs2(List<List<Integer>> graph, int[] count, int[] res, int cur, int parent, int n) {
        for (int i : graph.get(cur)) {
            if (i == parent) {
                continue;
            }
            res[i] = res[cur] - count[i] + n - count[i];
            dfs2(graph, count, res, i, cur, n);
        }
    }
}