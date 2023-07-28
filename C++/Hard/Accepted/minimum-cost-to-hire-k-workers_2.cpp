class Solution {
public:
    double mincostToHireWorkers(vector<int>& quality, vector<int>& wage, int k) {
        
        vector<pair<double, int>> workers;
        for (int i = 0; i < quality.size(); ++i) {
            workers.push_back({(double)wage[i] / quality[i], quality[i]});
        }
        sort(workers.begin(), workers.end());
        priority_queue<int> pq;
        int qsum = 0;
        double ans = DBL_MAX;
        for (auto worker: workers) {
            qsum += worker.second;
            pq.push(worker.second);
            if (pq.size() > k) {
                qsum -= pq.top();
                pq.pop();
            }
            if (pq.size() == k) {
                ans = min(ans, qsum * worker.first);
            }
        }
        return ans;
    }
};