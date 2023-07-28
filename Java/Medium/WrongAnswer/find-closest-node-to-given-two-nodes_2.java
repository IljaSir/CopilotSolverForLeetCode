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
                if (edges[i] != -1) {
                    dist1[i] = Math.min(dist1[i], dist1[edges[i]] + 1);
                }
            }
            if (i != node2) {
                if (edges[i] != -1) {
                    dist2[i] = Math.min(dist2[i], dist2[edges[i]] + 1);
                }
            }
        }
        int res = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int d = Math.max(dist1[i], dist2[i]);
            if (d < min) {
                min = d;
                res = i;
            }
        }
        return res;
    }
}