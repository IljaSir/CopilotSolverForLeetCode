class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        
        int N = grid.size();
        int ans = 0;
        vector<vector<bool>> visited(N, vector<bool>(N, false));
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({grid[0][0], 0, 0});
        visited[0][0] = true;
        vector<int> dx = {1, 0, -1, 0};
        vector<int> dy = {0, 1, 0, -1};
        while(!pq.empty()) {
            auto cur = pq.top();
            pq.pop();
            ans = max(ans, cur[0]);
            int x = cur[1];
            int y = cur[2];
            if(x == N - 1 && y == N - 1) {
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pq.push({grid[nx][ny], nx, ny});
                }
            }
        }
        return ans;
    }
};