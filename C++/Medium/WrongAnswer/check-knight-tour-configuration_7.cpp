class Solution {
public:
    bool checkValidGrid(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> visited(n*n, 0);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] < 0 || grid[i][j] >= n*n || visited[grid[i][j]]){
                    return false;
                }
                visited[grid[i][j]] = 1;
            }
        }
        return true;
    }
    bool checkValidKnightMove(int x1, int y1, int x2, int y2, int n){
        if(x1<0 || x1>=n || x2<0 || x2>=n || y1<0 || y1>=n || y2<0 || y2>=n){
            return false;
        }
        if(abs(x1-x2)==2 && abs(y1-y2)==1){
            return true;
        }
        if(abs(x1-x2)==1 && abs(y1-y2)==2){
            return true;
        }
        return false;
    }
    bool checkKnightTour(vector<vector<int>>& grid) {
        int n = grid.size();
        int x = 0, y = 0;
        for(int i=0; i<n*n-1; i++){
            int x1 = x, y1 = y;
            int x2 = grid[x][y] / n, y2 = grid[x][y] % n;
            if(!checkValidKnightMove(x1, y1, x2, y2, n)){
                return false;
            }
            x = x2, y = y2;
        }
        return true;
    }
    bool checkKnightTourConfiguration(vector<vector<int>>& grid) {
        if(!checkValidGrid(grid)){
            return false;
        }
        return checkKnightTour(grid);
    }
};