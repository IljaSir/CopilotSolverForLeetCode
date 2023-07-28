class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        
        int n = grid.size();
        if(n == 0 || grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        vector<vector<int>> dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        queue<pair<int, int>> q;
        q.push({0, 0});
        grid[0][0] = 1;
        int res = 1;
        while(!q.empty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                auto p = q.front();
                q.pop();
                if(p.first == n-1 && p.second == n-1) return res;
                for(int j = 0; j < 8; j++) {
                    int x = p.first + dir[j][0];
                    int y = p.second + dir[j][1];
                    if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        q.push({x, y});
                    }
                }
            }
            res++;
        }
        return -1;
    }
};