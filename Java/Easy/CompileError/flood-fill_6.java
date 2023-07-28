class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if (image[sr][sc] == color) return image;
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, oldColor, color);
        return image;
    }
}