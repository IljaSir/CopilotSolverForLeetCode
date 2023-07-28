class Solution {
public:
    int shortestBridge(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int i,j;
        int count = 0;
        int flag = 0;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                    flag = 1;
                    break;
                }
            }
            if(flag==1)break;
        }
        queue<pair<int,int>> q;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.push({i,j});
                }
            }
        }
        while(!q.empty()){
            count++;
            int len = q.size();
            for(i=0;i<len;i++){
                int x = q.front().first;
                int y = q.front().second;
                q.pop();
                if(x-1>=0 && grid[x-1][y]==1)return count;
                if(x+1<m && grid[x+1][y]==1)return count;
                if(y-1>=0 && grid[x][y-1]==1)return count;
                if(y+1<n && grid[x][y+1]==1)return count;
                if(x-1>=0 && grid[x-1][y]==0){
                    grid[x-1][y] = 2;
                    q.push({x-1,y});
                }
                if(x+1<m && grid[x+1][y]==0){
                    grid[x+1][y] = 2;
                    q.push({x+1,y});
                }
                if(y-1>=0 && grid[x][y-1]==0){
                    grid[x][y-1] = 2;
                    q.push({x,y-1});
                }
                if(y+1<n && grid[x][y+1]==0){
                    grid[x][y+1] = 2;
                    q.push({x,y+1});
                }
            }
        }
        return -1;
    }
};