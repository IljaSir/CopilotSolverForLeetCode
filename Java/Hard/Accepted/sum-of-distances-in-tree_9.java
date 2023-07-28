class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        int[] res = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(graph, 0, -1, res, count);
        dfs2(graph, 0, -1, res, count);

        return res;
    }

    private void dfs(List<List<Integer>> graph, int node, int parent, int[] res, int[] count) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(graph, child, node, res, count);
                count[node] += count[child];
                res[node] += res[child] + count[child];
            }
        }
    }

    private void dfs2(List<List<Integer>> graph, int node, int parent, int[] res, int[] count) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                res[child] = res[node] - count[child] + count.length - count[child];
                dfs2(graph, child, node, res, count);
            }
        }
    }
}