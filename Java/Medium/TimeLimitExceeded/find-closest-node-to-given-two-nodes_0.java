class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int[] dist1 = new int[edges.length];
        int[] dist2 = new int[edges.length];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        dist1[node1] = 0;
        dist2[node2] = 0;
        int node = node1;
        while (edges[node] != -1) {
            dist1[edges[node]] = dist1[node] + 1;
            node = edges[node];
        }
        node = node2;
        while (edges[node] != -1) {
            dist2[edges[node]] = dist2[node] + 1;
            node = edges[node];
        }
        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < edges.length; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                if (min > dist1[i] + dist2[i]) {
                    min = dist1[i] + dist2[i];
                    res = i;
                }
            }
        }
        return res;
    }
}