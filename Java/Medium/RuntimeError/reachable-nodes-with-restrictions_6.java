class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        int[] restrictedSet = new int[n];
        for (int i : restricted) {
            restrictedSet[i] = 1;
        }
        int[][] graph = new int[n][n];
        for (int[] e : edges) {
            graph[e[0]][e[1]] = e[2] + 1;
            graph[e[1]][e[0]] = e[2] + 1;
        }
        return reachableNodes(graph, restrictedSet);
    }
    
    private int reachableNodes(int[][] graph, int[] restricted) {
        int n = graph.length;
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int dist = cur[1];
            if (dist > distance[node]) continue;
            for (int nei = 0; nei < n; nei++) {
                if (graph[node][nei] > 0) {
                    int d = dist + graph[node][nei];
                    if (d < distance[nei]) {
                        distance[nei] = d;
                        pq.offer(new int[]{nei, d});
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (distance[i] != Integer.MAX_VALUE) ans++;
        }
        for (int[] e : graph) {
            for (int i : e) {
                if (i > 0) ans--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] > 0) {
                    int d = distance[i] + distance[j] + 1;
                    ans += Math.min(d, graph[i][j]);
                }
            }
        }
        return ans;
    }
}