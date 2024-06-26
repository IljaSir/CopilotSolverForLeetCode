class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        int n = image.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = temp;
                left++;
                right--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = (image[i][j] == 0) ? 1 : 0;
            }
        }
        return image;
    }
}