class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        
        int m = maze.size();
        int n = maze[0].size();
        int x = entrance[0];
        int y = entrance[1];
        queue<pair<int,int>> q;
        q.push({x,y});
        int step = 0;
        vector<vector<int>> visited(m, vector<int>(n, 0));
        visited[x][y] = 1;
        while(!q.empty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                auto cur = q.front();
                q.pop();
                int x = cur.first;
                int y = cur.second;
                if(x == 0 || x == m-1 || y == 0 || y == n-1){
                    if(x == entrance[0] && y == entrance[1])
                        continue;
                    else
                        return step;
                }
                if(x-1>=0 && maze[x-1][y] == '.' && visited[x-1][y] == 0){
                    q.push({x-1,y});
                    visited[x-1][y] = 1;
                }
                if(x+1<m && maze[x+1][y] == '.' && visited[x+1][y] == 0){
                    q.push({x+1,y});
                    visited[x+1][y] = 1;
                }
                if(y-1>=0 && maze[x][y-1] == '.' && visited[x][y-1] == 0){
                    q.push({x,y-1});
                    visited[x][y-1] = 1;
                }
                if(y+1<n && maze[x][y+1] == '.' && visited[x][y+1] == 0){
                    q.push({x,y+1});
                    visited[x][y+1] = 1;
                }
            }
            step++;
        }
        return -1;
    }
};