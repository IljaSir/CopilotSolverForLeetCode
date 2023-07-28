class Solution {
public:
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        
        vector<vector<int>> maxLocal(grid.size()-2,vector<int>(grid[0].size()-2,0));
        for(int i=0;i<grid.size()-2;i++){
            for(int j=0;j<grid[0].size()-2;j++){
                int max=0;
                for(int k=i;k<i+3;k++){
                    for(int l=j;l<j+3;l++){
                        if(grid[k][l]>max){
                            max=grid[k][l];
                        }
                    }
                }
                maxLocal[i][j]=max;
            }
        }
        return maxLocal;
    }
};