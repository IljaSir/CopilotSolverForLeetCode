class Solution {
public:
    double maxAverageRatio(vector<vector<int>>& classes, int extraStudents) {
        
        priority_queue<pair<double, pair<int, int>>> pq;
        for (auto& c : classes) {
            pq.push({(double)(c[0] + 1) / (c[1] + 1) - (double)c[0] / c[1], {c[0], c[1]}});
        }
        while (extraStudents--) {
            auto [ratio, c] = pq.top(); pq.pop();
            pq.push({(double)(c.first + 2) / (c.second + 2) - (double)(c.first + 1) / (c.second + 1), {c.first + 1, c.second + 1}});
        }
        double res = 0;
        while (!pq.empty()) {
            auto [ratio, c] = pq.top(); pq.pop();
            res += (double)c.first / c.second;
        }
        return res / classes.size();
    }
};