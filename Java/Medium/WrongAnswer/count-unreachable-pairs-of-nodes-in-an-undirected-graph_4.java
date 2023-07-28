class Solution {
    public long countPairs(int n, int[][] edges) {
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int p1 = find(parent, edge[0]);
            int p2 = find(parent, edge[1]);
            if (p1 != p2) {
                parent[p1] = p2;
                n--;
            }
        }
        return (long) n * (n - 1) / 2 - edges.length;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}