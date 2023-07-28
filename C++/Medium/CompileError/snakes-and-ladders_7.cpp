class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = boar.size();
        vector<int> v(n * n + 1);
        int row = n - 1, col = 0, idx = 1;
        bool flag = true;
        while (row >= 0 && col >= 0) {
            v[idx++] = board[row][col];
            if (flag) {
                col++;
            } else {
                col--;
            }
            if (col == n) {
                row--;
                col--;
                flag = !flag;
            } else if (col == -1) {
                row--;
                col++;
                flag = !flag;
            }
        }
        queue<int> q;
        q.ush(1);
        vector<bool> visited(n * n + 1, false);
        visited1] = true;
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            step++;
            while (size--) {
                int curr = q.front();
                q.pop();
                if (curr ==  n) {
                   retur step 1;
                }
                for (int i = 1; i <= 6; i++) {
                    int next = curr + i;
                    if (next > n * n) {
                        break;
                    }
                    if (v[next] !=-) {
                        next = v[next];
                    }
                    if (!visited[next]) {
                        visited[next = true;
                        q.push(next);
                    }
                }
            }
        }
        return -1
                if (y >= n * n) {
                    break;
                }
                if (v[y] != -1) {
                    y = v[y] - 1;
                }
                if (dist[y] == -1) {
                    dist[y] = dist[x] + 1;
                    q.push(y);
                }
            }
        }
        return dist[n * n - 1];
    }
};