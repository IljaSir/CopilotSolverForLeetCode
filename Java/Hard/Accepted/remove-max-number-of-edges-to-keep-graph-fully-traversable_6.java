class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        int res = 0;
        int[] p1 = new int[n + 1];
        int[] p2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p1[i] = i;
            p2[i] = i;
        }
        for (int[] e : edges) {
            if (e[0] == 3) {
                if (!union(p1, e[1], e[2])) {
                    res++;
                } else {
                    union(p2, e[1], e[2]);
                }
            }
        }
        for (int[] e : edges) {
            if (e[0] == 1) {
                if (!union(p1, e[1], e[2])) {
                    res++;
                }
            } else if (e[0] == 2) {
                if (!union(p2, e[1], e[2])) {
                    res++;
                }
            }
        }
        int p = find(p1, 1);
        for (int i = 2; i <= n; i++) {
            if (find(p1, i) != p) {
                return -1;
            }
        }
        p = find(p2, 1);
        for (int i = 2; i <= n; i++) {
            if (find(p2, i) != p) {
                return -1;
            }
        }
        return res;
    }

    private int find(int[] p, int x) {
        if (p[x] != x) {
            p[x] = find(p, p[x]);
        }
        return p[x];
    }

    private boolean union(int[] p, int x, int y) {
        int px = find(p, x);
        int py = find(p, y);
        if (px == py) {
            return false;
        } else {
            p[px] = py;
            return true;
        }
    }
}