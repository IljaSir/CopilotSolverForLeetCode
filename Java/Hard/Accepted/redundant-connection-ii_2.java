class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int[] parent = new int[edges.length + 1];
        int[] candA = null, candB = null;
        for (int[] edge : edges) {
            if (parent[edge[1]] == 0) {
                parent[edge[1]] = edge[0];
            } else {
                candA = new int[] {parent[edge[1]], edge[1]};
                candB = new int[] {edge[0], edge[1]};
                edge[1] = 0;
            }
        }
        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[1] == 0) continue;
            int rootx = find(parent, edge[0]);
            int rooty = find(parent, edge[1]);
            if (rootx == rooty) {
                if (candA == null) return edge;
                return candA;
            }
            parent[rooty] = rootx;
        }
        return candB;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}