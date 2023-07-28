class Solution {
public:
    int projectionArea(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    ans++;
                }
            }
        }
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<m;j++){
                if(grid[i][j]>max){
                    max = grid[i][j];
                }
            }
            ans+=max;
        }
        for(int i=0;i<m;i++){
            int max = 0;
            for(int j=0;j<n;j++){
                if(grid[j][i]>max){
                    max = grid[j][i];
                }
            }
            ans+=max;
        }
        return ans;
    }
};