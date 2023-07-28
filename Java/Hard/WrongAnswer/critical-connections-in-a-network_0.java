class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] ids = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        dfs(graph, 0, 0, ids, low, visited, result);
        return result;
    }
    private int dfs(List<List<Integer>> graph, int at, int id, int[] ids, int[] low, boolean[] visited, List<List<Integer>> result) {
        visited[at] = true;
        ids[at] = id;
        low[at] = id;
        id++;
        for (int next : graph.get(at)) {
            if (!visited[next]) {
                id = dfs(graph, next, id, ids, low, visited, result);
                low[at] = Math.min(low[at], low[next]);
                if (ids[at] < low[next]) {
                    result.add(Arrays.asList(at, next));
                }
            } else {
                low[at] = Math.min(low[at], ids[next]);
            }
        }
        return id;
    }
}