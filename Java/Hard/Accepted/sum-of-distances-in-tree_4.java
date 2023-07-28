class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        int[] res = new int[n];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] count = new int[n];
        int[] dist = new int[n];
        dfs(graph, 0, -1, count, dist);
        dfs2(graph, 0, -1, count, dist, res);
        return res;
    }
    
    void dfs(List<Integer>[] graph, int node, int parent, int[] count, int[] dist) {
        for (int child : graph[node]) {
            if (child != parent) {
                dfs(graph, child, node, count, dist);
                count[node] += count[child];
                dist[node] += dist[child] + count[child];
            }
        }
        count[node]++;
    }
    
    void dfs2(List<Integer>[] graph, int node, int parent, int[] count, int[] dist, int[] res) {
        res[node] = dist[node];
        for (int child : graph[node]) {
            if (child != parent) {
                int prevDist = dist[node];
                int prevCount = count[node];
                dist[node] -= dist[child] + count[child];
                count[node] -= count[child];
                count[child] += count[node];
                dist[child] += dist[node] + count[node];
                dfs2(graph, child, node, count, dist, res);
                dist[node] = prevDist;
                count[node] = prevCount;
                count[child] -= count[node];
                dist[child] -= dist[node] + count[node];
            }
        }
    }
}