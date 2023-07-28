class Solution {
public:
    int shortestBridge(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> dir = {{0,1},{1,0},{0,-1},{-1,0}};
        vector<pair<int,int>> v1,v2;
        bool found = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(!found){
                        dfs(grid,i,j,v1);
                        found = true;
                    }else{
                        dfs(grid,i,j,v2);
                    }
                }
            }
        }
        int ans = INT_MAX;
        for(int i=0;i<v1.size();i++){
            for(int j=0;j<v2.size();j++){
                ans = min(ans,abs(v1[i].first-v2[j].first)+abs(v1[i].second-v2[j].second)-1);
            }
        }
        return ans;
    }
    void dfs(vector<vector<int>>& grid,int i,int j,vector<pair<int,int>>& v){
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> dir = {{0,1},{1,0},{0,-1},{-1,0}};
        grid[i][j] = 2;
        v.push_back({i,j});
        for(int d=0;d<4;d++){
            int x = i+dir[d][0];
            int y = j+dir[d][1];
            if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
                dfs(grid,x,y,v);
            }
        }
    }
};