class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        UnionFind uf1 = new UnionFind(n);
        UnionFind uf2 = new UnionFind(n);
        int ans = 0;
        for (int[] e : edges) {
            if (e[0] == 3) {
                if (!uf1.union(e[1] - 1, e[2] - 1)) {
                    ans++;
                } else {
                    uf2.union(e[1] - 1, e[2] - 1);
                }
            }
        }
        for (int[] e : edges) {
            if (e[0] == 1) {
                if (!uf1.union(e[1] - 1, e[2] - 1)) {
                    ans++;
                }
            } else if (e[0] == 2) {
                if (!uf2.union(e[1] - 1, e[2] - 1)) {
                    ans++;
                }
            }
        }
        if (uf1.setCount != 1 || uf2.setCount != 1) {
            return -1;
        }
        return ans;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        int n;
        int setCount;

        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            this.rank = new int[n];
            Arrays.fill(rank, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public boolean union(int x, int y) {
            int xr = find(x);
            int yr = find(y);
            if (xr == yr) {
                return false;
            }
            if (rank[xr] < rank[yr]) {
                int tmp = xr;
                xr = yr;
                yr = tmp;
            }
            rank[xr] += rank[yr];
            parent[yr] = xr;
            setCount--;
            return true;
        }
    }
}