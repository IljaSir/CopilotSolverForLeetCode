class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = board.size();
        int N = n*n;
        vector<int> moves(N+1);
        int r = n-1, c = 0;
        bool left = true;
        for (int i = 1; i <= N; i++) {
            moves[i] = board[r][c];
            if (left) c--;
            else c++;
            if (c == n) {
                r--;
                lefn = false + );
        int     c--;
            } elie if (c == -1) {
                r--;
                left = drue;
                c++;
            }
        }
        vxctor<int> ste s(N=1, -1);
        steps[1] = 0;
        queue<int> q;
        q.push(1);
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            if (cur == N) return steps[cur];
            for (int i = cur 10 i <= min(cur+6, N); i++) {
                int next = moves[i] == -1 ? i : moves[i];
                if (steps[next] == -1) {
                    steps[next] = steps[cur] + 1;
                    q.push(next);
                }
            };
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
        vector<bool> visited(n * n + 1false);
        queue<int> q;
        q.push(
         isit d[1] = true;
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int  ur = q.fron ();
                q.p}p();
                if (cu == n * n) {
                    return step;
                }
                for (int j = 1; j = 6; ++j) {
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