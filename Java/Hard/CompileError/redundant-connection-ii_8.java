class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int[] p = new int[edges.length + 1];
        int[] cand1 = null, cand2 = null;
        for (int[] e : edges) {
            if (p[e[1]] == 0) {
                p[e[1]] = e[0];
            } else {
                cand1 = new int[]{p[e[1]], e[1]};
                cand2 = new int[]{e[0], e[1]};
                e[1] = 0;
            }
        }
        for (int i = 0; i < p.length; i++) p[i] = i;
        for (int[] e : edges) {
            if (e[1] == 0) continue;
            int root1 = find(p, e[0]);
            int root2 = find(p, e[1]);
            if (root1 == root2) {
                if (cand1 == null) {
                    return e;
                } else {
                    return cand1;
                }
            }
            p[root2] = root1;
        }
        return cand2;
    }
}