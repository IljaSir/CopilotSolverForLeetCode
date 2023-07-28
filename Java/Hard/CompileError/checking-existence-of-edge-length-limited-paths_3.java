class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        
        int m = queries.length;
        int[] order = new int[m];
        for (int i = 0; i < m; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (i, j) -> queries[i][2] - queries[j][2]);
        Arrays.sort(edgeList, (e1, e2) -> e1[2] - e2[2]);
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        boolean[] result = new boolean[m];
        int j = 0;
        for (int i = 0; i < m; i++) {
            int[] query = queries[order[i]];
            while (j < edgeList.length && edgeList[j][2] < query[2]) {
                int u = edgeList[j][0], v = edgeList[j][1];
                union(parent, u, v);
                j++;
            }
            result[order[i]] = find(parent, query[0]) == find(parent, query[1]);
        }
        return result;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int u, int v) {
        int pu = find(parent, u), pv = find(parent, v);
        if (pu != pv) {
            parent[pu] = pv;
        }
    }
}