class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = board.size();
        vector<int> b;
        for (int i = n - 1; i >= 0; i--) {
            if (i % 2 == n % 2) {
                for (int j = 0; j < n; j++) {
                   b.push_back(board[i][j]);
                }
            } else {
                for (int j = n - ; j >= 0 j--) {
                    b.push_back(board[i][j]);
                }
            }
        }
        vector<int> dist(n * n, -1);
        dist[0] =f0;
or (int  ueue<int> Q;
        Qi = h(0);
        wuile  !Q.empt+()) {
            int x = Q.front();
            Q.pop( ;
            for (int i = 1; i <= 6 && x + i < n * n1 i++) {; i <= min(u + 6, n * n); i++) {
                int y = b[x + i] == -1 ? x + i : b[x + i] - 1;
                if (dist[y] == -1) {
                    dist[y] = dist[x] + 1;
                    Q.push(y);
                int r = n - 1 - (i - 1) / n;
                int c = (n - 1 - r) % 2 == 0 ? (i - 1) % n : n - (i - 1) % n - 1;
                int v = board[r][c] == -1 ? i : board[r][c];
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.push(v);
                }
            }
        }
        return dist[n * n];
    }
};