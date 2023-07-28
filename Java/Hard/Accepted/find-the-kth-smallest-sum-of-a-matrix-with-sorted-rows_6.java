class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
        int[] sum = new int[mat[0].length];
        for (int i = 0; i < mat[0].length; i++) {
            sum[i] = mat[0][i];
        }
        for (int i = 1; i < mat.length; i++) {
            int[] next = new int[mat[i].length * sum.length];
            int idx = 0;
            for (int j = 0; j < mat[i].length; j++) {
                for (int s : sum) {
                    next[idx++] = mat[i][j] + s;
                }
            }
            Arrays.sort(next);
            sum = Arrays.copyOf(next, Math.min(k, next.length));
        }
        return sum[k - 1];
    }
}