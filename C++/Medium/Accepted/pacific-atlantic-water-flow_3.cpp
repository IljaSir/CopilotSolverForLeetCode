class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        
        int m = heights.size();
        int n = heights[0].size();
        vector<vector<int>> res;
        vector<vector<int>> pacific(m, vector<int>(n, 0));
        vector<vector<int>> atlantic(m, vector<int>(n, 0));
        for (int i = 0; i < m; ++i) {
            dfs(heights, pacific, i, 0, INT_MIN);
            dfs(heights, atlantic, i, n - 1, INT_MIN);
        }
        for (int j = 0; j < n; ++j) {
            dfs(heights, pacific, 0, j, INT_MIN);
            dfs(heights, atlantic, m - 1, j, INT_MIN);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.push_back({i, j});
                }
            }
        }
        return res;
    }
    void dfs(vector<vector<int>> &heights, vector<vector<int>> &visited, int i, int j, int pre) {
        if (i < 0 || i >= heights.size() || j < 0 || j >= heights[0].size() || heights[i][j] < pre || visited[i][j]) {
            return;
        }
        visited[i][j] = 1;
        dfs(heights, visited, i + 1, j, heights[i][j]);
        dfs(heights, visited, i - 1, j, heights[i][j]);
        dfs(heights, visited, i, j + 1, heights[i][j]);
        dfs(heights, visited, i, j - 1, heights[i][j]);
    }
};