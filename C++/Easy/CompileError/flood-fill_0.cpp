class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;
        dfs(image, sr, sc, color, oldColor);
        return image;
    }
};