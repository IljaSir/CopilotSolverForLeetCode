class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        
        vector<vector<int>> res;
        int m = heights.size();
        int n = heights[0].size();
        vector<vector<int>> pacific(m, vector<int>(n, 0));
        vector<vector<int>> atlantic(m, vector<int>(n, 0));
        for(int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific, INT_MIN);
            dfs(heights, i, n - 1, atlantic, INT_MIN);
        }
        for(int i = 0; i < n; i++) {
            dfs(heights, 0, i, pacific, INT_MIN);
            dfs(heights, m - 1, i, atlantic, INT_MIN);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.push_back({i, j});
                }
            }
        }
        return res;
    }
    void dfs(vector<vector<int>>& heights, int i, int j, vector<vector<int>>& ocean, int pre) {
        if(i < 0 || i >= heights.size() || j < 0 || j >= heights[0].size() || heights[i][j] < pre || ocean[i][j]) {
            return;
        }
        ocean[i][j] = 1;
        dfs(heights, i + 1, j, ocean, heights[i][j]);
        dfs(heights, i - 1, j, ocean, heights[i][j]);
        dfs(heights, i, j + 1, ocean, heights[i][j]);
        dfs(heights, i, j - 1, ocean, heights[i][j]);
    }
};