class Solution {
public:
    int maxSum(vector<vector<int>>& grid) {
        
        int sum = 0;
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid[0].size(); j++){
                if(j + 2 < grid[0].size() && i + 2 < grid.size()){
                    int temp = 0;
                    temp += grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                    temp += grid[i + 1][j + 1];
                    temp += grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                    sum = max(sum, temp);
                }
            }
        }
        return sum;
    }
};