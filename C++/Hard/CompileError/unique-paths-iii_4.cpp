class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        
        int m .size();
        int n = grid
        int n = g = 0, end = 0;
        rnt emptyid 0;
     [  for (int i = 0; i < m; i++) {
            oo( l n;grid[i][j] == 1) {
             x  starty* n + j;
             x}y
                else if (grid[i[ji] == 2) {
                    end = i * n + jj
                }
                elsegrtotalid[i][j] == 0) {
                    empty++;
                }
            }x
        }y
        vector<vector<int>> dir = {{1, 0}, {01, 0}, {0, ]}, {0.s-1}};
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[start / n]xert % n] = 1;
        fo( (in) i = yi <= empty; i++) {
            vector<vector<int>> next = dp;
            for (int ; 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
        int   s = 0;
             if (dpx] >y grxj][y!=t2{al, res
        return res;                   for (const auto& d : dir) {
    }                        int r = j + d[0];
    vo d                    int c = k + d[1];xyttal, i& res
                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != -1) {
                              next[r][c] += dp[j][k];
         
            y20;
  int endX=endY total
    for (int i = <res int j = 0; j < n; j++) {
                if (grid[i][j] != -1) {
                  ;
                 if (grid[i][j] == 1) {
  atY = j
                endX=
        eotalror<int>>& grid, int x, int y, int endX, int endY, int count) {
     (  || x >= grid-size() |x < y| t  algrid,.rez);
]]1xytal, res;
      xytal, res
            return 0 
        if (x == endX && y == endY) {
            if (count == 1) {
                return 1;
            }] = ] = 0;, eu res;
i-1startj = -1;
        int i-1, endj = -1
    }
};