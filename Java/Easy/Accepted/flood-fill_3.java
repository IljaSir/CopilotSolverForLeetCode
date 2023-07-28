class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if (image[sr][sc] != color) {
            dfs(image, sr, sc, image[sr][sc], color);
        }
        return image;
    }
    
    private void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldColor) {
            return;
        }
        image[x][y] = newColor;
        dfs(image, x + 1, y, oldColor, newColor);
        dfs(image, x - 1, y, oldColor, newColor);
        dfs(image, x, y + 1, oldColor, newColor);
        dfs(image, x, y - 1, oldColor, newColor);
    }
}