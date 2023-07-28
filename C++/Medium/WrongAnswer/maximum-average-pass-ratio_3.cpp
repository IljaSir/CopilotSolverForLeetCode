class Solution {
public:
    double maxAverageRatio(vector<vector<int>>& classes, int extraStudents) {
        
        priority_queue<pair<double, int>> pq;
        for (auto &c : classes) {
            pq.push({(double)(c[0] + 1) / (c[1] + 1) - (double)c[0] / c[1], c[1]});
        }
        while (extraStudents--) {
            auto [d, total] = pq.top();
            pq.pop();
            pq.push({(double)(total + 2) / (total + 1) - (double)(total + 1) / (total), total + 1});
        }
        double res = 0;
        while (!pq.empty()) {
            auto [d, total] = pq.top();
            pq.pop();
            res += (double)(total - 1) / total;
        }
        return res / classes.size();
    }
};