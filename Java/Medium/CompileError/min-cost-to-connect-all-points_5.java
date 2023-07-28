class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        int[][] edges = new int[n * (n - 1) / 2][3];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges[k][0] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges[k][1] = i;
                edges[k][2] = j;
                k++;
            }
        }
        Arrays.sort(edges, (a, b) -> a[0] - b[0]);
        UnionFind uf = new UnionFind(n);
        int res = 0;
        for (int[] edge : edges) {
            if (uf.union(edge[1], edge[2])) {
                res += edge[0];
            }
        }
        return res;
    }
}
    }
}