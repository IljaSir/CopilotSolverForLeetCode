class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int[] conflict = new int[]{-1, -1};
        int[] cycle = new int[]{-1, -1};
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = new int[]{node1, node2};
            } else {
                parent[node2] = node1;
                if (find(parent, node1) == node2) {
                    cycle = new int[]{node1, node2};
                }
            }
        }
        if (conflict[0] == -1) {
            return cycle;
        } else {
            if (cycle[0] == -1) {
                return conflict;
            } else {
                for (int i = n - 1; i >= 0; i--) {
                    if (edges[i][1] == conflict[1]) {
                        return edges[i];
                    }
                }
            }
        }
        return new int[0];
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}