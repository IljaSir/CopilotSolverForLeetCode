class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int p1 = find(edge[0], parent);
            int p2 = find(edge[1], parent);
            if (p1 == p2) {
                return edge;
            } else {
                union(p1, p2, parent);
            }
        }
        return null;
    }

    private int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent[i], parent);
    }
}