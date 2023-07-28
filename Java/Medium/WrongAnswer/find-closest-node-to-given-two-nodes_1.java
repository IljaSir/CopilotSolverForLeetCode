class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;
        for (int i = 0; i < n; i++) {
            if (i != node1) {
                int j = edges[i];
                if (j != -1) {
                    dist1[i] = dist1[j] + 1;
                }
            }
            if (i != node2) {
                int j = edges[i];
                if (j != -1) {
                    dist2[i] = dist2[j] + 1;
                }
            }
        }
        int ans = -1;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                int d = Math.max(dist1[i], dist2[i]);
                if (d < max) {
                    max = d;
                    ans = i;
                } else if (d == max) {
                    ans = Math.min(ans, i);
                }
            }
        }
        return ans;
    }
}