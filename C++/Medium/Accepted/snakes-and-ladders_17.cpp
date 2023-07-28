class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = board.size();
        vector<int> pos(1, 1);
        vector<bool> visited(n * n + 1, false);
        visited[1] = true;
        int step = 0;
        while (!pos.empty()) {
            vector<int> next;
            for (int p : pos) {
                if (p == n * n) return step;
                for (int i = 1; i <= 6; i++) {
                    int next_pos = p + i;
                    if (next_pos > n * n) break;
                    int row = (next_pos - 1) / n;
                    int col = (next_pos - 1) % n;
                    if (row % 2 == 1) col = n - 1 - col;
                    row = n - 1 - row;
                    if (board[row][col] != -1) next_pos = board[row][col];
                    if (!visited[next_pos]) {
                        visited[next_pos] = true;
                        next.push_back(next_pos);
                    }
                }
            }
            pos = next;
            step++;
        }
        return -1;
    }
};