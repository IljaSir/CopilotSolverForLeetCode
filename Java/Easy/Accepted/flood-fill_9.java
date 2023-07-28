class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        // base case
        if (image[sr][sc] == color) {
            return image;
        }
        int originColor = image[sr][sc];
        dfs(image, sr, sc, originColor, color);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int originColor, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != originColor) {
            return;
        }
        image[sr][sc] = color;
        dfs(image, sr + 1, sc, originColor, color);
        dfs(image, sr - 1, sc, originColor, color);
        dfs(image, sr, sc + 1, originColor, color);
        dfs(image, sr, sc - 1, originColor, color);
    }
}