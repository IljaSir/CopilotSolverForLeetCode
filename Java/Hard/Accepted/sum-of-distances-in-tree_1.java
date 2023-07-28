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
        int[] ans = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        dfs1(graph, ans, count, 0, -1);
        dfs2(graph, ans, count, 0, -1);
        return ans;
    }
    private void dfs1(List<List<Integer>> graph, int[] ans, int[] count, int node, int parent) {
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            dfs1(graph, ans, count, child, node);
            count[node] += count[child];
            ans[node] += ans[child] + count[child];
        }
    }
    private void dfs2(List<List<Integer>> graph, int[] ans, int[] count, int node, int parent) {
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            ans[child] = ans[node] - count[child] + count.length - count[child];
            dfs2(graph, ans, count, child, node);
        }
    }
}