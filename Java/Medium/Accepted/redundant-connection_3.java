class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int p1 = find(parent, edge[0]);
            int p2 = find(parent, edge[1]);
            if (p1 == p2) {
                return edge;
            }
            parent[p1] = p2;
        }
        return new int[2];
    }

    private int find(int[] parent, int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }
}