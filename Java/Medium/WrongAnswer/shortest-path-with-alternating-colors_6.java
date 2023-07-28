class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            dist[i][0] = dist[i][1] = n + 1;
        }
        dist[0][0] = dist[0][1] = 0;
        boolean[][] visited = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int color = cur[1];
            visited[node][color] = true;
            for (int[] edge : color == 0 ? redEdges : blueEdges) {
                if (edge[0] == node) {
                    int next = edge[1];
                    if (!visited[next][color ^ 1]) {
                        dist[next][color ^ 1] = Math.min(dist[next][color ^ 1], dist[node][color] + 1);
                        q.offer(new int[]{next, color ^ 1});
                    }
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i][0] == n + 1 && dist[i][1] == n + 1) {
                ans[i] = -1;
            } else {
                ans[i] = Math.min(dist[i][0], dist[i][1]);
            }
        }
        return ans;
    }
}