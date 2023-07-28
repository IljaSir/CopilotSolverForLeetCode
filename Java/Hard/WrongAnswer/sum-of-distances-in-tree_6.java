class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        int[] ret = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] sizes = new int[n];
        int[] distances = new int[n];
        dfs(graph, 0, -1, sizes, distances);
        dfs2(graph, 0, -1, sizes, distances, ret);
        return ret;
    }
    
    private void dfs(List<List<Integer>> graph, int node, int parent, int[] sizes, int[] distances) {
        int size = 1;
        int distance = 0;
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            dfs(graph, neighbor, node, sizes, distances);
            size += sizes[neighbor];
            distance += distances[neighbor] + sizes[neighbor];
        }
        sizes[node] = size;
        distances[node] = distance;
    }
    
    private void dfs2(List<List<Integer>> graph, int node, int parent, int[] sizes, int[] distances, int[] ret) {
        ret[node] = distances[node];
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            int oldDistance = distances[node];
            int oldSize = sizes[node];
            distances[node] = oldDistance - sizes[neighbor] - distances[neighbor];
            sizes[node] = oldSize - sizes[neighbor];
            distances[neighbor] = distances[node] + sizes[node];
            sizes[neighbor] = sizes[node];
            dfs2(graph, neighbor, node, sizes, distances, ret);
            distances[node] = oldDistance;
            sizes[node] = oldSize;
        }
    }
}