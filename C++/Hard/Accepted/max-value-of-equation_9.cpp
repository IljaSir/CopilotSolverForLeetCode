class Solution {
public:
    int findMaxValueOfEquation(vector<vector<int>>& points, int k) {
        
        int n = points.size();
        int res = INT_MIN;
        deque<pair<int, int>> dq; // {y - x, x}
        for (int i = 0; i < n; ++i) {
            int x = points[i][0];
            int y = points[i][1];
            while (!dq.empty() && x - dq.front().second > k) {
                dq.pop_front();
            }
            if (!dq.empty()) {
                res = max(res, x + y + dq.front().first);
            }
            while (!dq.empty() && y - x >= dq.back().first) {
                dq.pop_back();
            }
            dq.push_back({y - x, x});
        }
        return res;
    }
};