class Solution {
public:
    int findMaxValueOfEquation(vector<vector<int>>& points, int k) {
        
        int n = points.size();
        int ans = INT_MIN;
        deque<pair<int, int>> dq;
        for (int i = 0; i < n; i++) {
            while (!dq.empty() && points[i][0] - dq.front().first > k) {
                dq.pop_front();
            }
            if (!dq.empty()) {
                ans = max(ans, dq.front().second + points[i][1] + points[i][0]);
            }
            while (!dq.empty() && dq.back().second - points[i][0] <= points[i][1]) {
                dq.pop_back();
            }
            dq.push_back({points[i][0], points[i][1] - points[i][0]});
        }
        return ans;
    }
};