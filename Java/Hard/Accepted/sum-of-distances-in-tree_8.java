class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        int[] res = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        int[] count = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs1(graph, count, sum, 0, -1);
        dfs2(graph, count, sum, 0, -1, n);
        return sum;
    }
    
    private void dfs1(List<List<Integer>> graph, int[] count, int[] sum, int node, int parent) {
        for (int nei : graph.get(node)) {
            if (nei == parent) {
                continue;
            }
            dfs1(graph, count, sum, nei, node);
            count[node] += count[nei];
            sum[node] += sum[nei] + count[nei];
        }
        count[node]++;
    }
    
    private void dfs2(List<List<Integer>> graph, int[] count, int[] sum, int node, int parent, int n) {
        for (int nei : graph.get(node)) {
            if (nei == parent) {
                continue;
            }
            sum[nei] = sum[node] - count[nei] + n - count[nei];
            dfs2(graph, count, sum, nei, node, n);
        }
    }
}