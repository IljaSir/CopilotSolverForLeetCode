class Solution {
public:
    bool containsCycle(vector<vector<char>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        vector<vector<int>> directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]) continue;
                queue<pair<int,int>> q;
                q.push({i, j});
                visited[i][j] = true;
                while(!q.empty()){
                    int x = q.front().first;
                    int y = q.front().second;
                    q.pop();
                    for(auto d : directions){
                        int nx = x + d[0];
                        int ny = y + d[1];
                        if(nx<0 || nx>=m || ny<0 || ny>=n || grid[nx][ny]!=grid[i][j]) continue;
                        if(visited[nx][ny]) return true;
                        visited[nx][ny] = true;
                        q.push({nx, ny});
                    }
                }
            }
        }
        return false;
    }
};