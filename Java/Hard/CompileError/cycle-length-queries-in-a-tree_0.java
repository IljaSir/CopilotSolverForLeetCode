class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        
        int m = queries.length;
        int[] ans = new int[m];
        int[] parent = new int[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            parent[i] = i / 2;
        }
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int[] pa = new int[1 << n];
            int[] pb = new int[1 << n];
            int[] sa = new int[1 << n];
            int[] sb = new int[1 << n];
            int[] len = new int[1 << n];
            int[] dep = new int[1 << n];
            int[] vis = new int[1 << n];
            int[] que = new int[1 << n];
            int head = 0;
            int tail = 0;
            vis[a] = 1;
            que[tail++] = a;
            while (head < tail) {
                int u = que[head++];
                if (u == b) {
                    break;
                }
                if (u * 2 < (1 << n)) {
                    if (vis[u * 2] == 0) {
                        vis[u * 2] = 1;
                        que[tail++] = u * 2;
                        pa[u * 2] = u;
                        dep[u * 2] = dep[u] + 1;
                    }
                }
                if (u * 2 + 1 < (1 << n)) {
                    if (vis[u * 2 + 1] == 0) {
                        vis[u * 2 + 1] = 1;
                        que[tail++] = u * 2 + 1;
                        pa[u * 2 + 1] = u;
                        dep[u * 2 + 1] = dep[u] + 1;
                    }
                }
                if (vis[parent[u]] == 0) {
                    vis[parent[u]] = 1;
                    que[tail++] = parent[u];
                    pa[parent[u]] = u;
                    dep[parent[u]] = dep[u] + 1;
                }
            }
            head = 0;
            tail = 0;
            vis[b] = 1;
    }
}