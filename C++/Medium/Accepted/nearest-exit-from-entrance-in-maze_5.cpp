class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        
        int m = maze.size();
        int n = maze[0].size();
        vector<vector<int>> dir = {{0,1},{0,-1},{1,0},{-1,0}};
        queue<vector<int>> q;
        q.push(entrance);
        int step = 0;
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                auto cur = q.front();
                q.pop();
                for(int j = 0; j < 4; j++){
                    int x = cur[0] + dir[j][0];
                    int y = cur[1] + dir[j][1];
                    if(x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+') continue;
                    if((x == 0 || x == m - 1 || y == 0 || y == n - 1) && (x != entrance[0] || y != entrance[1])) return step + 1;
                    maze[x][y] = '+';
                    q.push({x,y});
                }
            }
            step++;
        }
        return -1;
    }
};