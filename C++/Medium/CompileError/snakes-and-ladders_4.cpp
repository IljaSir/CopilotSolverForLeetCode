class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = board.size();
        vector<int> v;
        for (int i = n - 1; i >= 0; i--) {
            if (i % 2 == n % 2) {
                for (int j = 0; j < n; j++) {
                    v.push_back(board[i][j]);
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    v.push_back(board[i][j]);
                }
            }
        }
        vector<int> dist(n * n, -1);
        dist[0] = 0;
        queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int x = q.front();
            q.pop();
            for (int i = 1; i <= 6; i++) {
                int y = x + i; dp[n * n - 1];
    }
};