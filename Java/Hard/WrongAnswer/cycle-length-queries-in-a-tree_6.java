class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int m = queries.length;
        int[] parent = new int[1 << n];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i >> 1;
        }
        for (int i = 0; i < m; i++) {
            int a = queries[i][0], b = queries[i][1];
            int pa = find(a, parent), pb = find(b, parent);
            if (pa == pb) {
                ans[i] = -1;
            } else {
                parent[pa] = pb;
                ans[i] = (1 << n) - 1;
            }
        }
        return ans;
    }
    int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}