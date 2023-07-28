class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int[] ans = new int[k];
        int[] count = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            count[i] = sum;
        }
        int index = 0;
        while (k > 0) {
            int min = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] < count[min]) {
                    min = i;
                }
            }
            count[min] = Integer.MAX_VALUE;
            ans[index++] = min;
            k--;
        }
        return ans;
    }
}