class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        int[] result = new int[n];
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] count = new int[n];
        int[] distance = new int[n];
        dfs1(0, -1, graph, count, distance);
        dfs2(0, -1, graph, count, distance);
        return distance;
    }
    
    private void dfs1(int u, int parent, List<Set<Integer>> graph, int[] count, int[] distance) {
        for (int v : graph.get(u)) {
            if (v == parent) {
                continue;
            }
            dfs1(v, u, graph, count, distance);
            count[u] += count[v];
            distance[u] += distance[v] + count[v];
        }
        count[u]++;
    }
    
    private void dfs2(int u, int parent, List<Set<Integer>> graph, int[] count, int[] distance) {
        for (int v : graph.get(u)) {
            if (v == parent) {
                continue;
            }
            distance[v] = distance[u] - count[v] + count.length - count[v];
            dfs2(v, u, graph, count, distance);
        }
    }
}