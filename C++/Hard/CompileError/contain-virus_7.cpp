class Solution {
public:
    int containVirus(vector<vector<int>>& isInfected) {
        
        int m = isInfected.size();
        int n = isInfected[0].size();
        int res = 0;
        while (true) {
            int maxArea = 0;
            int maxAreaI = -1;
            int maxAreaJ = -1;
            vector<vector<bool>> visited(m, vector<bool>(n, false));
            vector<vector<int>> area(m, vector<int>(n, 0));
            vector<vector<int>> wall(m, vector<int>(n, 0));
            vector<vector<int>> neighbor(m, vector<int>(n, 0));
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        int tmpArea = 0;
                        dfs(isInfected, visited, area, wall, neighbor, i, j, tmpArea);
                        if (tmpArea > maxArea) {
                            maxArea = tmpArea;
                            maxAreaI = i;
                            maxAreaJ = j;
                        }
                    }
                }
            }
            if (maxArea == 0) {
                break;
            }
            res += wall[maxAreaI][maxAreaJ];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1 && area[i][j] == 0) {
                        isInfected[i][j] = 2;
                    }
                }
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 2) {
                        if (i > 0 && isInfected[i - 1][j] == 0) {
                            isInfected[i - 1][j] = 1;
                        }
                        if (i < m - 1 && isInfected[i + 1][j] == 0) {
                            isInfected[i + 1][j] = 1;
                        }
                        if (j > 0 && isInfected[i][j - 1] ==
    }
};