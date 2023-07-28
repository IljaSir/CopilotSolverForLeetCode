class Solution {
public:
    double maxAverageRatio(vector<vector<int>>& classes, int extraStudents) {
        
        priority_queue<pair<double, pair<int, int>>> pq;
        for (auto& c : classes) {
            pq.push({(double)(c[0] + 1) / (c[1] + 1) - (double)c[0] / c[1], {c[0], c[1]}});
        }
        while (extraStudents--) {
            auto p = pq.top();
            pq.pop();
            p.first = (double)(p.second.first + 2) / (p.second.second + 2) - (double)(p.second.first + 1) / (p.second.second + 1);
            p.second.first++;
            p.second.second++;
            pq.push(p);
        }
        double res = 0.0;
        while (!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            res += (double)p.second.first / p.second.second;
        }
        return res / classes.size();
    }
};