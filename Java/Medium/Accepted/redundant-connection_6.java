class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (find(parent, x) == find(parent, y)) {
                return edge;
            } else {
                union(parent, x, y);
            }
        }
        return new int[0];
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }
    
    private void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
        }
    }
}