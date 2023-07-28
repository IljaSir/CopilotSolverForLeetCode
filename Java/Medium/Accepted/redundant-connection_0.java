class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x != y) {
                parent[y] = x;
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    private int find(int[] parent, int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }
}