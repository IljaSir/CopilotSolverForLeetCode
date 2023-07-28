class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] parents = new int[edges.length + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int x = find(parents, edge[0]);
            int y = find(parents, edge[1]);
            if (x == y) {
                return edge;
            }
            parents[x] = y;
        }
        return new int[]{-1, -1};
    }
    private int find(int[] parents, int i) {
        if (parents[i] != i) {
            parents[i] = find(parents, parents[i]);
        }
        return parents[i];
    }
}