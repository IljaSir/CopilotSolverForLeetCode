class Solution {
public:
    bool possibleToStamp(vector<vector<int>>& grid, int stampHeight, int stampWidth) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> count(m*n, 0);
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                count[i*n+j] = grid[i][j];
            }
        }
        vector<int> target = count;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                target[i*n+j] = 1;
            }
        }
        queue<int> q;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == 0){
                    q.push(i*n+j);
                }
            }
        }
        while(!q.empty()){
            int cur = q.front();
            q.pop();
            int i = cur/n;
            int j = cur%n;
            for(int x=max(0, i-stampHeight+1); x<=min(m-stampHeight, i); ++x){
                for(int y=max(0, j-stampWidth+1); y<=min(n-stampWidth, j); ++y){
                    bool flag = true;
                    for(int r=0; r<stampHeight; ++r){
                        for(int c=0; c<stampWidth; ++c){
                            if(grid[x+r][y+c] == 0){
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(flag){
                        for(int r=0; r<stampHeight; ++r){
                            for(int c=0; c<stampWidth; ++c){
                                grid[x+r][y+c] = 0;
                                count[(x+r)*n+y+c] = 1;
                            }
                        }
                        for(int r=0; r<m; ++r){
                            for(int c=0; c<n; ++c){
                                if(count[r*n+c] == 0){
                                    q.push(r*n+c);
                                }
                            }
                        }
                    }
                }
            }
        }
        return count == target;
    }
};