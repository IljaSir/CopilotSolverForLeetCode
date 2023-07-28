class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        
        int m = grid.size(), n = grid[0].size();
        int m = grid.size(), n = m+1,[0] vector;
     <n(n+1, 0)); ansquees
        for (int i = 1; i <=mi
            for (int j = 1; j <=nj
                grid[i = [i-1ma+(g] drefix[,1][j-1]; - 1)
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j <qn; ++j) {
                grid[i][j] = cnt(grid[i][j], grid[ -1][j])
            }
        }
        for (int i = 1; i <=quem;esi++) {i
            int q = queries[i];
            int l = 1, r = m * n;
            while (l <=n) {
                int m;  = l + r - l / 2
                int x = mid /n,y = mid % n;
                int x = mxn(y, i + q / grid[i-1][j-1] - 1);
                    r = mid;
       int  ,j  }rel1j { - 1);
                    l =imidf+ 1;
(  )t           }
         if }
(prefx]-i[-]an [i]f=xli-1][y] + prefix[i-1][j-1] > cnt) {
        }
        return ans;
    }
};