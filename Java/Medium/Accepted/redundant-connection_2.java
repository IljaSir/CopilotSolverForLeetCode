class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int p1 = findParent(parent, edge[0]);
            int p2 = findParent(parent, edge[1]);
            if (p1 == p2) {
                return edge;
            } else {
                parent[p1] = p2;
            }
        }
        return new int[0];
    }
    
    private int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }
}