class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        int[][] graph = new int[n][n];
        for (int[] e : edges) {
            graph[e[0]][e[1]] = e[2] + 1;
            graph[e[1]][e[0]] = e[2] + 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : restricted) set.add(i);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (d > dist[u]) continue;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 0) continue;
                int nd = d + graph[u][v];
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{v, nd});
                }
            }
        }
        int res = set.contains(0) ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if (set.contains(i)) continue;
            res++;
            for (int j = i + 1; j < n; j++) {
                if (set.contains(j)) continue;
                if (dist[i] == Integer.MAX_VALUE || dist[j] == Integer.MAX_VALUE) continue;
                int d = dist[i] + dist[j] + 1;
                if (d <= graph[i][j]) {
                    res += graph[i][j] - d;
                }
            }
        }
        return res;
    }
}