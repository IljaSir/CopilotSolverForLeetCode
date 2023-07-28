class Solution {
public:
    int containVirus(vector<vector<int>>& isInfected) {
        
        int m = isInfected.size(), n = isInfected[0].size();
        int res = 0;
        vector<vector<int>> dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(true){
            vector<vector<int>> visited(m, vector<int>(n, 0));
            vector<vector<int>> wall(m, vector<int>(n, 0));
            vector<vector<int>> area(m, vector<int>(n, 0));
            vector<int> w;
            vector<int> a;
            int maxArea = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(isInfected[i][j] == 1 && !visited[i][j]){
                        int walls = 0, areas = 0;
                        queue<vector<int>> q;
                        q.push({i,j});
                        visited[i][j] = 1;
                        while(!q.empty()){
                            vector<int> cur = q.front();
                            q.pop();
                            areas++;
                            for(int k = 0; k < 4; k++){
                                int x = cur[0] + dir[k][0];
                                int y = cur[1] + dir[k][1];
                                if(x >= 0 && x < m && y >= 0 && y < n){
                                    if(isInfected[x][y] == 0 && !visited[x][y]){
                                        walls++;
                                        visited[x][y] = 1;
                                    }
                                    if(isInfected[x][y] == 1 && !visited[x][y]){
                                        q.push({x,y});
                                        visited[x][y] = 1;
                                    }
                                }
                            }
                        }
                        w.push_back(walls);
                        a.push_back(areas);
                        if(areas > maxArea){
                            maxArea = areas;
                        }
                    }
                }
            }
            if(maxArea == 0){
                break;
            }
            for(int i = 0; i < w.size(); i++){
                if(a[i] == maxArea){
                    res += w[i];
                }
                else{
                    res += w[i] + 1;
                }
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(isInf
    }
};