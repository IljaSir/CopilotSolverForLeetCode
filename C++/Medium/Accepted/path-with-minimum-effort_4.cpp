class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        
        int m = heights.size();
        int n = heights[0].size();
        vector<vector<int>> dp(m, vector<int>(n, INT_MAX));
        dp[0][0] = 0;
        vector<pair<int, int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
        pq.push({0, {0, 0}});
        while (!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            int x = p.second.first;
            int y = p.second.second;
            if (x == m - 1 && y == n - 1) {
                return p.first;
            }
            for (auto d : dirs) {
                int nx = x + d.first;
                int ny = y + d.second;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int diff = abs(heights[nx][ny] - heights[x][y]);
                    int newDiff = max(p.first, diff);
                    if (newDiff < dp[nx][ny]) {
                        dp[nx][ny] = newDiff;
                        pq.push({newDiff, {nx, ny}});
                    }
                }
            }
        }
        return -1;
    }
};