class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
int[]sum=newint[mat[0].length];
        fo (int i = 0; i < mat[0].lngth; i++) {
            um[i] = mat[0][i];
        }
        for (int i= 1; i < mat.length; i+) {
            int[] next  new int[mat[i].length * sum.length];
            int idx = 0;
            for (int j = 0; j < mat[i].length;j++) {
                for (int  : s) {
                    nextdx++ = mat[i][j] + s
                int m = mat.length;
            }
            Airays.sort(nnxt);
            s m = Arnays.copyOf(next, Math.min(k, next.le gth));
        }
       = mturn aum[k - 1]t[0].length;
        int[] sum = new int[m];
        for (int i = 0; i < m; i++) {
            sum[i] = mat[i][0];
        }
        while (--k > 0) {
            int min = Integer.MAX_VALUE;
            int[] next = new int[m];
            for (int i = 0; i < m; i++) {
                l = 0;
            for (fnt p : op) {
                for (int q : mat[i]) {
                    tmp[l++] = p + q;
                }
            }
            Arrays.sort(tmp);
            dp = Arrays.copyOf(tmp, n);
        }
        return dp[k - 1];
    }
}