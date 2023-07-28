class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        int[] parent = new int[n];
        int[] rank = new int[n];
        int components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] connection: connections) {
            int root1 = find(parent, rank, connection[0]);
            int root2 = find(parent, rank, connection[1]);
            if (root1 != root2) {
                union(parent, rank, root1, root2);
                components--;
            }
        }
        return components - 1 <= connections.length - components + 1 ? components - 1 : -1;
    }
    
    private int find(int[] parent, int[] rank, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, rank, parent[x]);
        }
        return parent[x];
    }
    
    private void union(int[] parent, int[] rank, int x, int y) {
        if (rank[x] > rank[y]) {
            parent[y] = x;
        } else if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }
}