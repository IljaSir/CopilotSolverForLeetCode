class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        
        int m = queries.length;
        for(int i = 0; i < m; i++) {
            queries[i] = new int[] {queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(queries, (a, b) -> a[2] - b[2]);
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        boolean[] res = new boolean[m];
        int idx = 0;
        for(int[] q : queries) {
            int u = q[0], v = q[1], limit = q[2], id = q[3];
            while(idx < edgeList.length && edgeList[idx][2] < limit) {
                int x = edgeList[idx][0], y = edgeList[idx][1];
                int px = find(x, parent);
                int py = find(y, parent);
                if(px != py) {
                    parent[px] = py;
                }
                idx++;
            }
            if(find(u, parent) == find(v, parent)) {
                res[id] = true;
            }
        }
        return res;
    }
    private int find(int x, int[] parent) {
        if(parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}