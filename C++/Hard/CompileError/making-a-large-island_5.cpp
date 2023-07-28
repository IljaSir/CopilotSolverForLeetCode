class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> visited(n, vector<int>(m, 0));
        vector<int> islandSize;
        islandSize.push_back(0);
        int islandCount = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    ++islandCount;
                    int size = 0;
                    dfs(grid, visited, i, j, size);
                    islandSize.push_back(size);
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    unordered_set<int> adjIsland;
                    if (i > 0 && grid[i-1][j] == 1) {
                        adjIsland.insert(visited[i-1][j]);
                    }
                    if (j > 0 && grid[i][j-1] == 1) {
                        adjIsland.insert(visited[i][j-1]);
                    }
                    if (i < n-1 && grid[i+1][j] == 1) {
                        adjIsland.insert(visited[i+1][j]);
                    }
                    if (j < m-1 && grid[i][j+1] == 1) {
                        adjIsland.insert(visited[i][j+1]);
                    }
                    for (auto island : adjIsland) {
                        area += islandSize[island];
                    }
                    maxArea = max(maxArea, area);
                }
            }
        }
        if (maxArea == 0) {
            return n * m;
        } else {
            return maxArea;
        }
    }
};