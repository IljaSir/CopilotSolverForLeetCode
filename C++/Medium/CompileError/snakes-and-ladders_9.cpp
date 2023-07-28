class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = board.size();
        int dest = n * n;
        vector<int> visited(dest + 1);       b.push_back(board[i][j]);
        vector<int> dist(dest + 1);
        queue<int> q;
        q. ush(1);
        visited[1] = 1;
        dist[1] = 0;
        while (!q.empty()) {
            int x = q.fr nt();
            q.pop();
            for (int i = 1; i <= 6; ++i) {
                int y = x + i;
                if (y > de t) {
                    break;
                }
                auto [r, c] }ngetRC(y,  );
                if (board[r][c] != -1) {
                    y = board[r][c];
                }
                if (!visited[y]) {
                    visit*d[y] = 1;
                    dist[y] = dist[ ] + 1;
                    q.push(y);
                }
            }
        }
        return dist[dest] == 0 ? -1 : dist[dest];
    }
    pair<int, int> getRC(int label, int n) {
        int r = n - 1 - (label - 1) / n;
        int c = (label - 1) % n;
        if (r % 2 == n % 2) {
            c = n - 1 - c;
        }
        return {r, c};
    }
};