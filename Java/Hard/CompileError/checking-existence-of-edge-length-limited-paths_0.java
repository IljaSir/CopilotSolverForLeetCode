class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        
        int m = queries.length;
        for (int i = 0; i < m; ++i) queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        Arrays.sort(queries, (a, b) -> a[2] - b[2]);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        boolean[] res = new boolean[m];
        DSU dsu = new DSU(n);
        for (int i = 0, j = 0; i < m; ++i) {
            while (j < edgeList.length && edgeList[j][2] < queries[i][2]) {
                dsu.union(edgeList[j][0], edgeList[j][1]);
                ++j;
            }
            res[queries[i][3]] = dsu.find(queries[i][0]) == dsu.find(queries[i][1]);
        }
        return res;
    }
}
    }
}