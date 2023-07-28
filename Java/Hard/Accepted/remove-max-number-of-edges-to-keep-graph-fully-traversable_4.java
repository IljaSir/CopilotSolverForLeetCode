class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        int res = 0;
        int[] parentA = new int[n + 1];
        int[] parentB = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parentA[i] = i;
            parentB[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!union(parentA, edge[1], edge[2])) {
                    res++;
                } else {
                    union(parentB, edge[1], edge[2]);
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!union(parentA, edge[1], edge[2])) {
                    res++;
                }
            } else if (edge[0] == 2) {
                if (!union(parentB, edge[1], edge[2])) {
                    res++;
                }
            }
        }
        int rootA = find(parentA, 1);
        int rootB = find(parentB, 1);
        for (int i = 2; i <= n; i++) {
            if (find(parentA, i) != rootA || find(parentB, i) != rootB) {
                return -1;
            }
        }
        return res;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    
    private boolean union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX == rootY) {
            return false;
        }
        parent[rootX] = rootY;
        return true;
    }
}