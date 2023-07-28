class Solution {
public:
    int largest1BorderedSquare(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> rows(m, vector<int>(n,0));
        vector<vector<int>> cols(m, vector<int>(n,0));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    rows[i][j] = j>0?rows[i][j-1]+1:1;
                    cols[i][j] = i>0?cols[i-1][j]+1:1;
                }
            }
        }
        int ans = 0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int maxLen = min(rows[i][j], cols[i][j]);
                for(int k=maxLen;k>ans;k--){
                    if(rows[i-k+1][j]>=k && cols[i][j-k+1]>=k){
                        ans = k;
                        break;
                    }
                }
            }
        }
        return ans*ans;
    }
};