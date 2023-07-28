class Solution {
public:
    double mincostToHireWorkers(vector<int>& quality, vector<int>& wage, int k) {
        
        vector<pair<double, int>> workers;
        for (int i = 0; i < quality.size(); i++) {
            workers.push_back({(double)wage[i] / quality[i], quality[i]});
        }
        sort(workers.begin(), workers.end());
        int sumq = 0;
        double res = DBL_MAX;
        priority_queue<int> pq;
        for (auto worker : workers) {
            sumq += worker.second;
            pq.push(worker.second);
            if (pq.size() > k) {
                sumq -= pq.top();
                pq.pop();
            }
            if (pq.size() == k) {
                res = min(res, sumq * worker.first);
            }
        }
        return res;
    }
};