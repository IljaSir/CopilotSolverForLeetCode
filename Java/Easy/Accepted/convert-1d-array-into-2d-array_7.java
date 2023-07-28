class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        
        int[][] res = new int[m][n];
        if (original.length != m * n) {
            return new int[0][0];
        }
        int i = 0;
        for (int[] row : res) {
            for (int j = 0; j < n; j++) {
                row[j] = original[i++];
            }
        }
        return res;
    }
}