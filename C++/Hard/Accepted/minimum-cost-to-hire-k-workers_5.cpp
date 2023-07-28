class Solution {
public:
    double mincostToHireWorkers(vector<int>& quality, vector<int>& wage, int k) {
        
        int n = quality.size();
        vector<pair<double, int>> workers;
        for (int i = 0; i < n; i++) {
            workers.push_back({(double)wage[i] / quality[i], quality[i]});
        }
        sort(workers.begin(), workers.end());
        priority_queue<int> pq;
        int sum = 0;
        double res = 1e9;
        for (auto& worker : workers) {
            pq.push(worker.second);
            sum += worker.second;
            if (pq.size() > k) {
                sum -= pq.top();
                pq.pop();
            }
            if (pq.size() == k) {
                res = min(res, sum * worker.first);
            }
        }
        return res;
    }
};