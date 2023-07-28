class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int[] parent = new int[(int)Math.pow(2, n)];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i / 2;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int a = q[0], b = q[1];
            int[] depthA = depth(a, parent);
            int[] depthB = depth(b, parent);
            int[] depth = new int[depthA.length + depthB.length];
            int idx = 0;
            for (int d : depthA) {
                depth[idx++] = d;
            }
            for (int d : depthB) {
                depth[idx++] = d;
            }
            int lca = lca(a, b, parent);
            int[] depthLCA = depth(lca, parent);
            int[] depthLCA2 = new int[depthLCA.length];
            for (int j = 0; j < depthLCA.length; j++) {
                depthLCA2[j] = depthLCA[depthLCA.length - 1 - j];
            }
            int[] depth2 = new int[depth.length];
            for (int j = 0; j < depth.length; j++) {
                depth2[j] = depth[depth.length - 1 - j];
            }
            int[] depthLCA3 = new int[depthLCA.length + depthLCA2.length];
            idx = 0;
            for (int d : depthLCA) {
                depthLCA3[idx++] = d;
            }
            for (int d : depthLCA2) {
                depthLCA3[idx++] = d;
            }
            int[] depth3 = new int[depth.length + depth2.length];
            idx = 0;
            for (int d : depth) {
                depth3[idx++] = d;
            }
            for (int d : depth2) {
                depth3[idx++] = d;
            }
            int[] depthLCA4 = new int[depthLCA.length + depthLCA2.length - 1];
            idx = 0;
            for (int j = 1; j < depthLCA.length; j++) {
                depthL
    }
}