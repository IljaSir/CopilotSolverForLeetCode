class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        DSU dsuA = new DSU(n);
        DSU dsuB = new DSU(n);
        int ans = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!dsuA.union(edge[1] - 1, edge[2] - 1)) {
                    ans++;
                } else {
                    dsuB.union(edge[1] - 1, edge[2] - 1);
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!dsuA.union(edge[1] - 1, edge[2] - 1)) {
                    ans++;
                }
            } else if (edge[0] == 2) {
                if (!dsuB.union(edge[1] - 1, edge[2] - 1)) {
                    ans++;
                }
            }
        }
        if (dsuA.setCount != 1 || dsuB.setCount != 1) {
            return -1;
        }
        return ans;
    }

    class DSU {
        int[] parent;
        int[] rank;
        int setCount;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
            setCount = n;
        }

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public boolean union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return false;
            }
            if (rank[fx] < rank[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            rank[fx] += rank[fy];
            parent[fy] = fx;
            setCount--;
            return true;
        }
    }
}