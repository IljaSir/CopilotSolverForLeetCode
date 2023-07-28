class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], -1);
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u][v] = graph[v][u] = w;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{0, maxMoves});
        int res = 0;
        boolean[] seen = new boolean[n];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], moves = cur[1];
            if (seen[u]) {
                continue;
            }
            seen[u] = true;
            res++;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] >= 0) {
                    int w = graph[u][v];
                    if (moves > w && !seen[v]) {
                        pq.offer(new int[]{v, moves - w - 1});
                    }
                    graph[v][u] -= Math.min(moves, w);
                    res += Math.min(moves, w);
                }
            }
        }
        return res;
    }
}