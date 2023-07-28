class Solution {
public:
    int findMaxValueOfEquation(vector<vector<int>>& points, int k) {
        
        int n = points.size();
        int ans = INT_MIN;
        deque<pair<int, int>> q;
        for (int i = 0; i < n; ++i) {
            int x = points[i][0];
            int y = points[i][1];
            while (!q.empty() && x - q.front().first > k) {
                q.pop_front();
            }
            if (!q.empty()) {
                ans = max(ans, x + y + q.front().second);
            }
            while (!q.empty() && y - x > q.back().second) {
                q.pop_back();
            }
            q.push_back({x, y - x});
        }
        return ans;
    }
};