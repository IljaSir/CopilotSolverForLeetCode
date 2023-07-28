class Solution {
public:
    double maxAverageRatio(vector<vector<int>>& classes, int extraStudents) {
        
        auto cmp = [](const vector<int>& a, const vector<int>& b) {
            return (double)(a[0] + 1) / (a[1] + 1) - (double)a[0] / a[1] < (double)(b[0] + 1) / (b[1] + 1) - (double)b[0] / b[1];
        };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> pq(cmp);
        for (auto& c : classes) {
            pq.push(c);
        }
        while (extraStudents--) {
            auto c = pq.top();
            pq.pop();
            c[0]++;
            c[1]++;
            pq.push(c);
        }
        double sum = 0;
        while (!pq.empty()) {
            auto c = pq.top();
            pq.pop();
            sum += (double)c[0] / c[1];
        }
        return sum / classes.size();
    }
};