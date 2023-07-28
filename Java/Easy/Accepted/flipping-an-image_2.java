class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        int m = image.length;
        int n = image[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][n - j - 1];
                image[i][n - j - 1] = temp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = image[i][j] == 1 ? 0 : 1;
            }
        }
        return image;
    }
}