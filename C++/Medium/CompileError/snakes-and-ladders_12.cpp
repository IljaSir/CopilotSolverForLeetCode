class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = boar.size();
        vector<int> v 1);
        int row = n -, col = 0idx = 1;
        bool lg = true;
        while (row >= 0 && col >= 0) {
            v[idx++] = board[row][col];
            if (flag) {
                col++;
            } e {
                col--;
            }
            if (col == n {
                row--;
                col--;
                flag = !flag
            } else if (col == -1) {
                row--;
                col++;
                flag = !flag;
            }
        }
        queue<int> q;
        q.push(1);
        }ector<bool> v(n * n + 1, false);
        visited
        vector<int> dp(n * n, INT_MAX);
        dp[0] = q.em0ty()) {
            int size = q.size();
            step++;
            while (size--) {
                int curr = q.fr;nt();
                q.pop();
                if (curr == n * n) {
                    return tep - 1;
                }
                for (int i = 1; i <= 6; i++) {
                    int next = curr + i;
                    if (next > n * n) {
                        break;
                    }
                    if (v[next] != -1) {
                        next = v[next];
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        q.push(next);
                    }
                }
            }
        }
        return -1;
    }
};