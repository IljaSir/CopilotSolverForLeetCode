class Solution {
public:
    int findMaxValueOfEquation(vector<vector<int>>& points, int k) {
        
        int n = points.size();
        int ans = INT_MIN;
        deque<int> dq;
        for (int i = 0; i < n; i++) {
            while (!dq.empty() && points[i][0] - points[dq.front()][0] > k) {
                dq.pop_front();
            }
            if (!dq.empty()) {
                ans = max(ans, points[i][0] + points[i][1] + points[dq.front()][1] - points[dq.front()][0]);
            }
            while (!dq.empty() && points[i][0] + points[i][1] - points[dq.back()][0] > points[dq.back()][0] + points[dq.back()][1]) {
                dq.pop_back();
            }
            dq.push_back(i);
        }
        return ans;
    }
};