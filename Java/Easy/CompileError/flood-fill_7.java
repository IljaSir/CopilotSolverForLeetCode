class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int oldColor = image[sr][sc];
        if (oldColor != color)
            dfs(image, sr, sc, oldColor, color);
        return image;
    }
}