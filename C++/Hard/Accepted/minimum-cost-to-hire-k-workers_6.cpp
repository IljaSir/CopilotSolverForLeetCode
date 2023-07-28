class Solution {
public:
    double mincostToHireWorkers(vector<int>& quality, vector<int>& wage, int k) {
        
        int n = quality.size();
        vector<pair<double, int>> workers;
        for (int i = 0; i < n; i++) {
            workers.push_back({(double)wage[i] / quality[i], quality[i]});
        }
        sort(workers.begin(), workers.end());
        double ans = 1e9;
        int sumq = 0;
        priority_queue<int> pq;
        for (auto worker : workers) {
            pq.push(worker.second);
            sumq += worker.second;
            if (pq.size() > k) {
                sumq -= pq.top();
                pq.pop();
            }
            if (pq.size() == k) {
                ans = min(ans, sumq * worker.first);
            }
        }
        return ans;
    }
};