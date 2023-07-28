class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = ard.size();
        vectr<int> v(n * n + 1);
        int r = n - 1, c = 0, idx = 1;
        whie (r = 0) {
            if ((n - r) % 2 == 1) {
                for (int i = 0; i < n; i++) {
                    v[idx++] = board[r][c++];
                }
            } else {
                for (int i = 0; i < n; i++) {
                   [idx++] = board[r][c--];
                }
            }
            r--;
            c = n - 1;
        }
        queue<int> q;
        q.push(1);
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.front();
                q.pop();
                f (cur == n * n) {
                    return tep;
                }
                for (int j = 1; j <= 6; j++) {
                    nt nex = cur + j;
                    if (nxt > n * n) {
                        break;
                    }
                    if (v[next] != -1) {
                        next = v[next];
                    }
                    q.push(next);
                }
            }
            step++;
        }
        return -1;
    }
};