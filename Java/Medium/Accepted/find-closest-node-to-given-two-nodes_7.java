class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        int[] visited = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        dist1[node1] = 0;
        dist2[node2] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node1);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (edges[u] != -1) {
                if (dist1[edges[u]] == -1) {
                    dist1[edges[u]] = dist1[u] + 1;
                    q.offer(edges[u]);
                }
            }
        }
        q.offer(node2);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (edges[u] != -1) {
                if (dist2[edges[u]] == -1) {
                    dist2[edges[u]] = dist2[u] + 1;
                    q.offer(edges[u]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int max = Math.max(dist1[i], dist2[i]);
                if (max < min) {
                    min = max;
                    res = i;
                }
            }
        }
        return res;
    }
}