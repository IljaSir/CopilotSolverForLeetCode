class Solution {
    public int[][] imageSmoother(int[][] img) {
        
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        int row = i + k;
                        int col = j + l;
                        if (row >= 0 && row < m && col >= 0 && col < n) {
                            sum += img[row][col];
                            count++;
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
}