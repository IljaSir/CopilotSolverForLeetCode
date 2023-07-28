class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        
        int m = queries.length;
        int[] ans = new int[m];
        int[] parent = new int[1 << n];
        int[] depth = new int[1 << n];
        int[] size = new int[1 << n];
        for (int i = 0; i < (1 << n); ++i) {
            parent[i] = i;
            depth[i] = 0;
            size[i] = 1;
        }
        for (int i = 0; i < m; ++i) {
            int a = queries[i][0], b = queries[i][1];
            int pa = find(parent, a), pb = find(parent, b);
            if (pa == pb) {
                ans[i] = -1;
                continue;
            }
            if (depth[pa] < depth[pb]) {
                int t = pa;
                pa = pb;
                pb = t;
            }
            parent[pb] = pa;
            size[pa] += size[pb];
            if (depth[pa] == depth[pb]) {
                depth[pa]++;
            }
            int d = depth[pa] - depth[pb];
            int s = size[pb];
            if (d % 2 == 0) {
                ans[i] = s;
            } else {
                ans[i] = (1 << n) - s;
            }
        }
        return ans;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}