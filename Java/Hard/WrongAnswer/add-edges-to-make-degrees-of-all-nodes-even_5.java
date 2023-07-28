class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        
        int[] degrees = new int[n];
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new HashSet<>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            degrees[u]++;
            degrees[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] % 2 == 1) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            int v = q.poll();
            degrees[u]++;
            degrees[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 0; i < n; i++) {
            if (degrees[i] % 2 == 1) {
                return false;
            }
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                count++;
            }
        }
        return count == 1;
    }
    private void dfs(Map<Integer, Set<Integer>> adj, boolean[] visited, int u) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(adj, visited, v);
            }
        }
    }
}