class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        
        int n = heights.size();
        int m = heights[0].size();
        vector<vector<int>> dp(n, vector<int>(m, INT_MAX));
        dp[0][0] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 0});
        vector<int> dx = {0, 0, 1, -1};
        vector<int> dy = {1, -1, 0, 0};
        while(!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            int x = p.second / m;
            int y = p.second % m;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int diff = abs(heights[x][y] - heights[nx][ny]);
                    int maxDiff = max(dp[x][y], diff);
                    if(maxDiff < dp[nx][ny]) {
                        dp[nx][ny] = maxDiff;
                        pq.push({dp[nx][ny], nx * m + ny});
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
};