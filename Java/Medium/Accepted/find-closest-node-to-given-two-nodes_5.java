class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int n = edges.length;
        int[] dist1 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        int[] dist2 = new int[n];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.offer(node1);
        dist1[node1] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            if (edges[u] == -1) continue;
            if (dist1[edges[u]] == Integer.MAX_VALUE) {
                dist1[edges[u]] = dist1[u] + 1;
                q.offer(edges[u]);
            }
        }
        q.offer(node2);
        dist2[node2] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            if (edges[u] == -1) continue;
            if (dist2[edges[u]] == Integer.MAX_VALUE) {
                dist2[edges[u]] = dist2[u] + 1;
                q.offer(edges[u]);
            }
        }
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                if (Math.max(dist1[i], dist2[i]) < min) {
                    min = Math.max(dist1[i], dist2[i]);
                    ans = i;
                }
            }
        }
        return ans;
    }
}