class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        
        int m = maze.size();
        int n = maze[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        visited[entrance[0]][entrance[1]] = true;
        queue<vector<int>> q;
        q.push(entrance);
        int step = 0;
        while(!q.empty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                vector<int> cur = q.front();
                q.pop();
                if((cur[0] == 0 || cur[0] == m - 1 || cur[1] == 0 || cur[1] == n - 1) && (cur[0] != entrance[0] || cur[1] != entrance[1])) {
                    return step;
                }
                vector<vector<int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for(auto dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+' || visited[x][y]) {
                        continue;
                    }
                    q.push({x, y});
                    visited[x][y] = true;
                }
            }
            step++;
        }
        return -1;
    }
};