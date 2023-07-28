class Solution {
public:
    double maxAverageRatio(vector<vector<int>>& classes, int extraStudents) {
        
        priority_queue<pair<double, int>> q;
        for (int i = 0; i < classes.size(); ++i) {
            double cur = (double)classes[i][0] / classes[i][1];
            q.push({cur, i});
        }
        while (extraStudents--) {
            auto p = q.top();
            q.pop();
            int i = p.second;
            classes[i][0]++;
            classes[i][1]++;
            double cur = (double)classes[i][0] / classes[i][1];
            q.push({cur, i});
        }
        double ans = 0;
        for (auto c : classes) {
            ans += (double)c[0] / c[1];
        }
        return ans / classes.size();
    }
};