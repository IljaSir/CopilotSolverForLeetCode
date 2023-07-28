class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        
        int m = maze.size(), n = maze[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        queue<pair<int, int>> q;
        q.push(make_pair(entrance[0], entrance[1]));
        visited[entrance[0]][entrance[1]] = 1;
        int count = 0;
        while (!q.empty()) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto node = q.front();
                q.pop();
                int x = node.first, y = node.second;
                if (x == 0 || y == 0 || x == m-1 || y == n-1) {
                    if (x != entrance[0] || y != entrance[1]) {
                        return count-1;
                    }
                }
                if (x > 0 && maze[x-1][y] == '.' && visited[x-1][y] == 0) {
                    q.push(make_pair(x-1, y));
                    visited[x-1][y] = 1;
                }
                if (y > 0 && maze[x][y-1] == '.' && visited[x][y-1] == 0) {
                    q.push(make_pair(x, y-1));
                    visited[x][y-1] = 1;
                }
                if (x < m-1 && maze[x+1][y] == '.' && visited[x+1][y] == 0) {
                    q.push(make_pair(x+1, y));
                    visited[x+1][y] = 1;
                }
                if (y < n-1 && maze[x][y+1] == '.' && visited[x][y+1] == 0) {
                    q.push(make_pair(x, y+1));
                    visited[x][y+1] = 1;
                }
            }
        }
        return -1;
    }
};