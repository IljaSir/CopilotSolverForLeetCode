class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        int n = image.length;
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = n - 1;
            while (l < r) {
                int temp = image[i][l];
                image[i][l] = image[i][r];
                image[i][r] = temp;
                l++;
                r--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
        }
        return image;
    }
}