class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        
        int[][] graph = new int[n][n];
        for (int[] e : edges) {
            graph[e[0]][e[1]] = graph[e[1]][e[0]] = e[2] + 1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        pq.offer(new int[]{maxMoves, 0});
        boolean[] visited = new boolean[n];
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int moves = cur[0], node = cur[1];
            if (visited[node]) continue;
            visited[node] = true;
            res++;
            for (int nei = 0; nei < n; nei++) {
                if (graph[node][nei] > 0) {
                    if (moves > graph[node][nei] && !visited[nei]) {
                        pq.offer(new int[]{moves - graph[node][nei], nei});
                    }
                    graph[nei][node] -= Math.min(moves, graph[node][nei]);
                    res += Math.min(moves, graph[node][nei]);
                }
            }
        }
        return res;
    }
}