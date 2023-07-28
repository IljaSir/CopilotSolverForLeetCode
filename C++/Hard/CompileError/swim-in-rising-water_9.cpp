class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int left = 0, right = n*n;
        int res = 0;
        while(left < right){
            int mid = left + (right - left)/2;
            if(dfs(grid, mid, 0, 0)){
                res = mid;
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
};