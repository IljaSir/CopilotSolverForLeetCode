class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = find(edge[0], parent);
            int root2 = find(edge[1], parent);
            if (root1 == root2) {
                return edge;
            }
            parent[root1] = root2;
        }
        return new int[] {};
    }

    private int find(int node, int[] parent) {
        while (parent[node] != node) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }
}