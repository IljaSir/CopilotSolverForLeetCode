class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2] + 1;
            graph[edge[1]][edge[0]] = edge[2] + 1;
        }
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int d = cur[1];
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            for (int i = 0; i < n; i++) {
                if (graph[node][i] == 0) {
                    continue;
                }
                int newD = d + graph[node][i];
                if (newD > dist[i]) {
                    dist[i] = newD;
                    pq.offer(new int[]{i, newD});
                }
                graph[i][node] = 0;
            }
        }
        int ans = 0;
        for (int node : restricted) {
            if (dist[node] >= 0) {
                ans++;
            }
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int w = edge[2];
            if (dist[a] >= 0 && dist[b] >= 0) {
                ans += Math.min(dist[a] + dist[b] + 1, w);
            } else {
                ans += Math.min(dist[a] + dist[b] + 1, w + Math.max(dist[a], dist[b]));
            }
        }
        return ans;
    }
}