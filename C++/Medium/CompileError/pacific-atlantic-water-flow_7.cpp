class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        
        vector<vector<int>> ret;
        int m = heights.size();
        if (m == 0) {
            return ret;
        }
        int n = heights[0].size();
        if (n == 0) {
            return ret;
        }
        vector<vector<bool>> pacific(m, vector<bool>(n, false));
        vector<vector<bool>> atlantic(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, m, n);
            dfs(heights, atlantic, i, n - 1, m, n);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, 0, i, m, n);
            dfs(heights, atlantic, m - 1, i, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ret.push_back({i, j});
                }
            }
        }
        return ret;
    }
    
    void dfs(vector<vector<int>>& heights, vector<vector<bool>>& visited, int i, int j, int m, int n) {
        visited[i][j] = true;
        if (i > 0 && !visited[i-1][j] && heights[i-1][j] >= heights[i][j]) {
            dfs(heights, visited, i-1, j, m, n);
        }
        if (i < m - 1 && !visited[i+1][j] && heights[i+1][j] >= heights[i][j]) {
            dfs(heights, visited, i+1, j, m, n);
        }
        if (j > 0 && !visited[i][j-1] && heights[i][j-1] >= heights[i][j]) {
            dfs(heights, visited, i, j-1, m, n);
        }
        if (j < n - 1 && !visited[i][j+1] && heights[i][j+1] >= heights[i][j]) {
            dfs(heights, visited, i, j+1
    }
};