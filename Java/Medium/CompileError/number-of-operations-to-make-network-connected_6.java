class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] conn : connections) {
            uf.union(conn[0], conn[1]);
        }
        return uf.count() - 1;
    }
}
    }
}