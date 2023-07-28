class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        int[] in = new int[n + 1];
        for (int[] r : relations) {
            int f = r[0], t = r[1];
            int pf = find(p, f);
            int pt = find(p, t);
            if (pf != pt) {
                p[pf] = pt;
                in[t]++;
            }
        }
        int[] q = new int[n + 1];
        int l = 0, r = 0;
        for (int i = 1; i <= n; i++) {
            if (in[i] == 0) {
                q[r++] = i;
            }
        }
        int ans = 0;
        while (l < r) {
            ans++;
            int nr = 0;
            for (int i = 0; i < k && l < r; i++) {
                int u = q[l++];
                for (int[] r : relations) {
                    int f = r[0], t = r[1];
                    if (f == u) {
                        in[t]--;
                        if (in[t] == 0) {
                            q[r + nr++] = t;
                        }
                    }
                }
            }
            r += nr;
        }
        return ans;
    }

    int find(int[] p, int x) {
        if (p[x] != x) {
            p[x] = find(p, p[x]);
        }
        return p[x];
    }
}