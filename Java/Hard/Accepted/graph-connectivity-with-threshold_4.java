class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        
        List<Boolean> res = new ArrayList<>();
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = threshold + 1; i <= n; i++) {
            for (int j = 2; i * j <= n; j++) {
                union(parent, i, i * j);
            }
        }
        for (int[] q : queries) {
            res.add(find(parent, q[0]) == find(parent, q[1]));
        }
        return res;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    private void union(int[] parent, int i, int j) {
        int pi = find(parent, i);
        int pj = find(parent, j);
        if (pi == pj) {
            return;
        }
        parent[pi] = pj;
    }
}