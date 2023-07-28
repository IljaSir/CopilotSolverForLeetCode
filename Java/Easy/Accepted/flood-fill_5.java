class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int oldColor = image[sr][sc];
        if (oldColor == color) {
            return image;
        }
        fill(image, sr, sc, color, oldColor);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int color, int oldColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = color;
        fill(image, sr + 1, sc, color, oldColor);
        fill(image, sr - 1, sc, color, oldColor);
        fill(image, sr, sc + 1, color, oldColor);
        fill(image, sr, sc - 1, color, oldColor);
    }
}