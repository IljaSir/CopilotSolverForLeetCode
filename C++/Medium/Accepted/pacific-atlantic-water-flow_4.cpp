class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        
        int m = heights.size();
        int n = heights[0].size();
        vector<vector<int>> res;
        vector<vector<int>> pacific(m, vector<int>(n, 0));
        vector<vector<int>> atlantic(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, INT_MIN, i, 0);
            dfs(heights, atlantic, INT_MIN, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, INT_MIN, 0, j);
            dfs(heights, atlantic, INT_MIN, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.push_back({i, j});
                }
            }
        }
        return res;
    }
    void dfs(vector<vector<int>>& heights, vector<vector<int>>& ocean, int height, int i, int j) {
        int m = heights.size();
        int n = heights[0].size();
        if (i < 0 || i >= m || j < 0 || j >= n || ocean[i][j] || heights[i][j] < height) {
            return;
        }
        ocean[i][j] = 1;
        dfs(heights, ocean, heights[i][j], i + 1, j);
        dfs(heights, ocean, heights[i][j], i - 1, j);
        dfs(heights, ocean, heights[i][j], i, j + 1);
        dfs(heights, ocean, heights[i][j], i, j - 1);
    }
};