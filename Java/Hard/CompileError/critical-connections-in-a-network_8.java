class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 1) {
            return result;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> conn : connections) {
            int from = conn.get(0);
            int to = conn.get(1);
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        }

        int[] visited = new int[n];
        int[] low = new int[n];
        int[] id = new int[n];
        int[] parent = new int[n];
        Arrays.fill(id, -1);
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            if (id[i] == -1) {
                dfs(graph, i, visited, low, id, parent, result);
            }
        }
        return result;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int node, int[] visited, int[] low, int[] id, int[] parent, List<List<Integer>> result) {
        visited[node] = 1;
        id[node] = low[node] = time++;
        for (int nei : graph.get(node)) {
            if (nei == parent[node]) {
                continue;
            }
            if (visited[nei] == 1) {
                low[node] = Math.min(low[node], id[nei]);
            } else {
                parent[nei] = node;
                dfs(graph, nei, visited, low, id, parent, result);
                low[node] = Math.min(low[node], low[nei]);
                if (low[nei] > id[node]) {
                    result.add(Arrays.asList(node, nei));
                }
            }
        }
    }
}