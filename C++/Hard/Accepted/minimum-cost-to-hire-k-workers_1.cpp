class Solution {
public:
    double mincostToHireWorkers(vector<int>& quality, vector<int>& wage, int k) {
        
        int n = quality.size();
        vector<pair<double, int>> workers;
        for (int i = 0; i < n; ++i) {
            workers.push_back({(double)wage[i] / quality[i], quality[i]});
        }
        sort(workers.begin(), workers.end());
        double ans = DBL_MAX, qsum = 0;
        priority_queue<int> q;
        for (auto worker: workers) {
            q.push(worker.second);
            qsum += worker.second;
            if (q.size() > k) {
                qsum -= q.top();
                q.pop();
            }
            if (q.size() == k) ans = min(ans, qsum * worker.first);
        }
        return ans;
    }
};