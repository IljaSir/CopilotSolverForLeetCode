class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        // build graph
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        // dfs
        double[] res = new double[1];
        dfs(graph, 1, target, t, res, new boolean[n + 1]);
        return res[0];
    }
    private void dfs(List<Integer>[] graph, int node, int target, int t, double[] res, boolean[] visited) {
        if (t == 0) {
            if (node == target) {
                res[0] = 1.0;
            }
            return;
        }
        visited[node] = true;
        int count = 0;
        for (int next : graph[node]) {
            if (!visited[next]) {
                count++;
            }
        }
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(graph, next, target, t - 1, res, visited);
                if (res[0] > 0) {
                    res[0] /= count;
                    break;
                }
            }
        }
        visited[node] = false;
    }
}