class Solution {
public:
    int shortestBridge(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> dir = {{0,1},{0,-1},{1,0},{-1,0}};
        vector<vector<bool>> visited(n, vector<bool>(m,false));
        queue<pair<int,int>> q;
        bool flag = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    dfs(grid, i, j, n, m, visited, q);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        int ans = 0;
        while(!q.empty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int x = q.front().first;
                int y = q.front().second;
                q.pop();
                for(int k=0; k<4; k++){
                    int nx = x + dir[k][0];
                    int ny = y + dir[k][1];
                    if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny]) continue;
                    if(grid[nx][ny]==1) return ans;
                    visited[nx][ny] = true;
                    q.push({nx,ny});
                }
            }
            ans++;
        }
        return ans;
    }
};