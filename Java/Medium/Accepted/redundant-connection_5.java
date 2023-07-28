class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] parents = new int[edges.length + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            if (find(parents, edge[0]) == find(parents, edge[1])) {
                return edge;
            }
            union(parents, edge[0], edge[1]);
        }
        return new int[2];
    }
    
    private void union(int[] parents, int i, int j) {
        int x = find(parents, i);
        int y = find(parents, j);
        parents[x] = y;
    }
    
    private int find(int[] parents, int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
}