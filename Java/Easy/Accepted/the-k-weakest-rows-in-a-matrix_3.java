class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int[][] sorted = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            sorted[i][0] = i;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                sorted[i][1]++;
            }
        }
        Arrays.sort(sorted, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sorted[i][0];
        }
        return result;
    }
}