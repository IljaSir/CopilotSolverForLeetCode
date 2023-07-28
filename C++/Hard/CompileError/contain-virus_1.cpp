class Solution {
public:
    int containVirus(vector<vector<int>>& isInfected) {
        
        int m = isInfected.size();
        int n = isInfected[0].size();
        int res = 0;
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (true) {
            vector<vector<int>> visited(m, vector<int>(n, 0));
            vector<vector<int>> wall(m, vector<int>(n, 0));
            vector<int> area;
            vector<int> perim;
            int maxArea = 0;
            int maxAreaIdx = -1;
            int maxPerim = 0;
            int maxPerimIdx = -1;
            int idx = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && visited[i][j] == 0) {
                        int a = 0;
                        int p = 0;
                        dfs(isInfected, visited, wall, dirs, a, p, i, j);
                        area.push_back(a);
                        perim.push_back(p);
                        if (a > maxArea) {
                            maxArea = a;
                            maxAreaIdx = idx;
                        }
                        if (p > maxPerim) {
                            maxPerim = p;
                            maxPerimIdx = idx;
                        }
                        idx++;
                    }
                }
            }
            if (maxAreaIdx == -1) {
                break;
            }
            res += maxPerim;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (wall[i][j] == 1) {
                        isInfected[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i < area.size(); i++) {
                if (i != maxAreaIdx) {
                    res += area[i];
                }
            }
        }
        return res;
    }
};