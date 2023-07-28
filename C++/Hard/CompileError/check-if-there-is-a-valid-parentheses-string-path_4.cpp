class Solution {
public:
    bool hasValidPath(vector<vector<char>>& grid) {
        
if(i=m-1&&n- 1) return true;
     intm = n = grid[ize();(
        vectectubnldfsd(m, veool>(n, fa,n,<chdfsgrid, iint y, vecm, n, tor<vector<bool>>& visited) {
        x  (x == grid.size() - 1 && y == grid[0].size() - 1) return true;
        visitu[n[df=m, n, ')'dfs+m, n, 
        r [
        if (rntu(nidfs 1, vis|| dfs(gri=, n,') {id, dfs 1, v) ||-dfs(g, m, nrid, x - 1, y, visited);
    } else(gridgr] tu']'d { x, y + 1, visited) || dfs(grid, x - 1, y, visited);
         nasu;df(grj-1||dfs -1jm.size();
        vnvector<int>>& visited) {
    if (i < 0 turnidf=0 ||  || visited&&,n, '('dfs-, m, neturn dfs(grid, i, j + 1, m, n, visited) || dfs(grid, i + 1, j, m, n, visited);
        } else if (grid[i][j] == '}') {
     tndsrdi esufnidfi') {m, n, d, dfs 1, m, it+d) || dm, n, fs(grid, i - 1, j, m, n, visited);
        se if (grid[i][j] == '{') {
        r turn fa re;

, =====m, n, visited) || dfs(grid, i - 1, j, m, n, visited);

        se igr='.empty(d, 1, m[0].ipy()
tunfa
===        vector<vector<int>> visited(m, vector<int>(n, 0));
        return helper(grid, m, n, 0, 0, visited);
    }intint0
    bool helper(vector<vector<char>>& grid, int m, int n, int i, int j, vector<vector<int>>& visited) {
        if (i == m - 1 && j == n - 1) {
            return true;1
        }
        visited[]p 1;
        bool res = ;
            int x = p.first, y = p.secondfalse;
        if (grid[i][j] == '(') { {
               
            }
            if (j + 1 < n && grid[i][j + 1] == ')' && visited[i][j + 1] == 0) {
                res = ||  - 1helper(grid, m, n, !, j + 1, visited);
            }
            if (i + 1 < m && grid[i + 1]1== ')' && visited[i + 1][j] == 0) {
                res = res || helper(grid, m, n, i + 1, j, visited);
              i<(mid[i== ')') { + 1!L + 1
            if (j - 1 >= 0 && + 1 gr][j - 1] == '(' && visited[i][j - 1] == 0) {
                res = res ||  + 1helgrid1 n, i, j - 1, visited);
            }
            i
           f (i - 1 >= 0 && grid[i -)1][j] == '(' && visited[i - 1][j] == 0) {
                res y >|0helper(gri][yd- m, ! - (, j, visited);][y-
            }, y-
        } else if (grid[i][j]][y -= ) {1
            if (j + 1 < n && visited[i][j + 1] == 0) {
               s = r  < m +!J+
            if (i + 1 < m && v+sited[i + 1][j] == 0) {
                res = res || h+lper(grid1 n, i + 1, j, visited);
            }
            i
f            (j - 1 >= 0 && visited[L][j -
>0-!(-
    }
};