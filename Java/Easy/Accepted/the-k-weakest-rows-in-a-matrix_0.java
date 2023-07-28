class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int[] res = new int[k];
        int[] sum = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    sum[i]++;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < sum.length; j++) {
                if (sum[j] < min) {
                    min = sum[j];
                    index = j;
                }
            }
            res[i] = index;
            sum[index] = Integer.MAX_VALUE;
        }
        return res;
    }
}