class Solution {
public:
    int shortestBridge(vector<vector<int>>& grid) {
        
        int N = grid.size();
        int M = grid[0].size();
        int dir[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
        vector<vector<bool>> visited(N,vector<bool>(M,false));
        queue<pair<int,int>> q;
        bool found = false;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]==1){
                    dfs(grid,visited,i,j,dir,q);
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        int ans = 0;
        while(!q.empty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                auto cur = q.front();
                q.pop();
                int x = cur.first;
                int y = cur.second;
                for(int k=0;k<4;k++){
                    int nx = x+dir[k][0];
                    int ny = y+dir[k][1];
                    if(nx<0||nx>=N||ny<0||ny>=M) continue;
                    if(grid[nx][ny]==1) return ans;
                    if(grid[nx][ny]==0){
                        grid[nx][ny] = 2;
                        q.push({nx,ny});
                    }
                }
            }
            ans++;
        }
        return ans;
    }
    void dfs(vector<vector<int>>& grid, vector<vector<bool>>& visited, int x, int y, int dir[4][2], queue<pair<int,int>>& q){
        int N = grid.size();
        int M = grid[0].size();
        visited[x][y] = true;
        grid[x][y] = 2;
        q.push({x,y});
        for(int i=0;i<4;i++){
            int nx = x+dir[i][0];
            int ny = y+dir[i][1];
            if(nx<0||nx>=N||ny<0||ny>=M) continue;
            if(visited[nx][ny]) continue;
            if(grid[nx][ny]==1) dfs(grid,visited,nx,ny,dir,q);
        }
    }
};