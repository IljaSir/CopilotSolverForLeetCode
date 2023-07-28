class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        
        int n = heights.size();
        int m = heights[0].size();
        vector<vector<int>> dp(n, vector<int>(m, INT_MAX));
        dp[0][0] = 0;
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
        pq.push({0, {0, 0}});
        while(!pq.empty()) {
            int x = pq.top().second.first;
            int y = pq.top().second.second;
            int w = pq.top().first;
            pq.pop();
            if(dp[x][y] < w) continue;
            if(x == n-1 && y == m-1) return w;
            if(x > 0) {
                int t = max(w, abs(heights[x][y] - heights[x-1][y]));
                if(dp[x-1][y] > t) {
                    dp[x-1][y] = t;
                    pq.push({t, {x-1, y}});
                }
            }
            if(x < n-1) {
                int t = max(w, abs(heights[x][y] - heights[x+1][y]));
                if(dp[x+1][y] > t) {
                    dp[x+1][y] = t;
                    pq.push({t, {x+1, y}});
                }
            }
            if(y > 0) {
                int t = max(w, abs(heights[x][y] - heights[x][y-1]));
                if(dp[x][y-1] > t) {
                    dp[x][y-1] = t;
                    pq.push({t, {x, y-1}});
                }
            }
            if(y < m-1) {
                int t = max(w, abs(heights[x][y] - heights[x][y+1]));
                if(dp[x][y+1] > t) {
                    dp[x][y+1] = t;
                    pq.push({t, {x, y+1}});
                }
            }
        }
        return 0;
    }
};