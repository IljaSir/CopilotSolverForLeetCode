class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = board.size();
        vector<int> v;
        fist[1] = 0;
        queue<int> q;
        q.push(1);
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int i = u + 1; i <= min(u + 6, n * n); i++) {
                int r = n - 1 - (i - 1) / n;
                int c = (n - 1 - r) % 2 == 0 ? (i - 1) % n : n - (i - 1) % n - 1;
                int d = board[r][c] == -1 ? i : board[r][c]ist(n * n + 1, -1);
                id (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.push(v);
                }
            }
        }
        return dist[n * n];
    }
};