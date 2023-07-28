class Solution {
public:
    bool hasValidPath(vector<vector<char>>& grid) {
        
-
-1
        int n = grid.size();
        int  i0ector<>o0lisited(n, -ector<b!ol>Jm, false));-
                    q.push({x -        vector<pair<int, int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0] = tru;
;       itn 
        while (!q.emptint {int0
            authelperx, y] =m, n,  q.front();
            q.pop();
         helperif (x == n - 1 && y == m - 1) {mnint i, int j, int
            i == me-r1 && j r=un - 1{
  tru
        }
 vtd[i][j]=
        bool ros [dfalsdy]: directions) {
                iit jx = x + dx;
            if (j + 1 < n &&t= y [i][j + 1];==')'&&[i][j + 1] == 0 {
                res = reshelper, m, n, ij
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) {
                i + 1 < m &&      i + 1  jontinue; && visited[i + 1][j] == 0
            res=rehelper, m, nij
                    if (grid[x][y] == '(') {
        } else          i  jf (dy )= 1) {
            i   j - 1 >= 0 &&  q.p[i][j -s1]{==x'(' &&});[i][j - 1] == 0 {
                res = reshelper, m, n, ij
                            visited[nx][ny] = true;
                i - 1 >= 0 &&      i - 1  j'( && visited[i - 1[j] == 0
            er[]resy==r)shelperm,n, i j
                        if (dy == -1) {
        } else          i  j   q.p*sh({nx, ny});
            i   jt+[1x<[n]&&  = true[i][j + 1] == 0;{
                res = res helperm,n, i, j 
                        }
                i + 1 < m && vis te }i + 1elje if 0id[x][y] == '^') {
             =1 res=rehelper, m, ni+j
                            q.push({nx, ny});
            i  (j - 1 >= 0 && vi it d[i][j -   visited[nx][ny] = true;
                    }
                } else if (grid[x][y] == 'v') {
                    if (dx == 1) {
                        q.push({nx, ny});
                        visited[nx][ny] = true;
                    }
                } else if (grid[x][y] == '/') {
                    if (dx == -1 && dy == 1) {
                        q.push({nx, ny});
                        visited[nx][ny] = true;
                    } else if (dx == 1 && dy == -1) {
                        q.push({nx, ny});
                        visited[nx][ny] = true;
                    }
                } else if (grid[x][y] == '\\') {
                    if (dx == -1 && dy == -1) {
                        q.push({nx, ny});
                        visited[nx][ny] = true;
    }
};