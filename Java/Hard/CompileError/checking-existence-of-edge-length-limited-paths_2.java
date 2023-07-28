class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        
        boolean[] res = new boolean[queries.length];
        int[] order = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> queries[a][2] - queries[b][2]);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n);
        for (int i = 0, j = 0; i < order.length; i++) {
            while (j < edgeList.length && edgeList[j][2] < queries[order[i]][2]) {
                uf.union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            res[order[i]] = uf.find(queries[order[i]][0]) == uf.find(queries[order[i]][1]);
        }
        return res;
    }
    class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }
}