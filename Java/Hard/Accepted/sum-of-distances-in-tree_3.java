class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        int[] ans = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] count = new int[n];
        int[] distance = new int[n];
        dfs(0, -1, graph, count, distance);
        dfs2(0, -1, graph, count, distance);
        return distance;
    }

    private void dfs(int node, int parent, List<List<Integer>> graph, int[] count, int[] distance) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node, graph, count, distance);
                count[node] += count[child];
                distance[node] += distance[child] + count[child];
            }
        }
        count[node]++;
    }

    private void dfs2(int node, int parent, List<List<Integer>> graph, int[] count, int[] distance) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                distance[child] = distance[node] - count[child] + count.length - count[child];
                dfs2(child, node, graph, count, distance);
            }
        }
    }
}