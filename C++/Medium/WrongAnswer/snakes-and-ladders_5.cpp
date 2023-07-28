class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = board.size();
        vector<int> pos(n * n + 1);
        int idx = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (idx % 2 == 0) {
                for (int j = 0; j < n; ++j) {
                    pos[++idx] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; --j) {
                    pos[++idx] = board[i][j];
                }
            }
        }
        vector<bool> visited(n * n + 1, false);
        queue<int> q;
        q.push(1);
        visited[1] = true;
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int cur = q.front();
                q.pop();
                if (cur == n * n) {
                    return step;
                }
                for (int j = 1; j <= 6; ++j) {
                    int next = cur + j;
                    if (next > n * n) {
                        break;
                    }
                    if (pos[next] != -1) {
                        next = pos[next];
                    }
                    if (visited[next]) {
                        continue;
                    }
                    q.push(next);
                    visited[next] = true;
                }
            }
            ++step;
        }
        return -1;
    }
};