class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                edges.add(new int[]{dist(points, i, j), i, j});
            }
        }
        Collections.sort(edges, (a, b) -> a[0] - b[0]);
        int ret = 0, num = 1;
        for (int[] edge: edges) {
            int d = edge[0], x = edge[1], y = edge[2];
            if (uf.unite(x, y)) {
                ret += d;
                num += 1;
                if (num == n) {
                    break;
                }
            }
        }
        return ret;
    }

    public int dist(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
    }
}