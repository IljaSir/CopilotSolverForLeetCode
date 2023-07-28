class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int n = edges.length;
        int[] parent = new int[n];
        int[] depth = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            depth[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                int p1 = find(parent, i);
                int p2 = find(parent, edges[i]);
                if (p1 != p2) {
                    if (depth[p1] < depth[p2]) {
                        parent[p1] = p2;
                        depth[p2] += depth[p1];
                    } else {
                        parent[p2] = p1;
                        depth[p1] += depth[p2];
                    }
                }
            }
        }
        int p1 = find(parent, node1);
        int p2 = find(parent, node2);
        if (p1 != p2) {
            return -1;
        }
        int d1 = 0, d2 = 0;
        while (node1 != p1) {
            node1 = edges[node1];
            d1++;
        }
        while (node2 != p2) {
            node2 = edges[node2];
            d2++;
        }
        return d1 > d2 ? node1 : node2;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}