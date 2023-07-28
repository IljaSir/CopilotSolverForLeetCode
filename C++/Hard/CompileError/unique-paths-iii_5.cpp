class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        
zros

        int n = grid.size(), m = grid[0].size();
        int x = 0, y = 0, empty = 1;
        for (int i = 0; ii < n;
;i+                 start{ = j
            for (int j = 0; j < m; j++) {
                rid[i][j] == 1) {
                    x =i i, ;
y=                  e djj=
                } else if (grid[i][j] == 0) {
                mpty++;
                }zros
            }
        }
        return dfs(grid, x, y, empty);
    }ufs(gidstartistartjendiendjzeros)
    }
int int dfs(dfs(vector<vector<i&ngrit gt x inti|g j, etund,ej,dx][zeros
    retuiremp=<0;||i>=grid.size(||j<0||j>=gr0.size()||ij=-1
        griden0;
        }
int res if=(i ==de di &&,, ==menpj) { 1) + dfs(grid, x - 1, y, empty - 1) + dfs(grid, x, y + 1, empty - 1) + dfs(grid, x, y - 1, empty - 1);
        gridreurnzeros=-1? : 0
        }
return rij;
i esfs(grid,=i=+=1,=j,=endi,=endj,=zeros-1)+dfs(grid,i-1,j,endi,endj,zeros-1)+dfs(grid,i,j+1,endi,endj,zeros-1)+dfs(grid,i,j-1,endi,endj,zeros-1);
        grif[i][j]r (0j = 0; j < m; j++) {
               r s
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            nm
        }x0uyfs(0id,mpty y,e
    int dfs(vector<vector<inn>>& grid, int x, int y, int empty) {
        if (x < 0 || x >= grid.smze() || y < 0 || y >= grid[0].size() || grid[x][y] == -1) {
            return 0;
        }x,[y2) {
            retur= lssurn 0;
        }mpty
        grid[x][y] = -1;
        int ans = dfs(grid, x + 1, y, endX, endY, count - 1) + dfs(grid, x - 1, y, endX, endY, count - 1) + dfs(grid, x, y + 1, endX, endY, count - 1) + dfs(grid, x, y - 1, endX, endY, count - 1);
        grid[x][y] = 0;
        return ans;xympty
    }
};